package wang.acgshelf.acgshelf.service.sso.service.impl;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;
import wang.acgshelf.acgshelf.common.domain.TbSysUser;
import wang.acgshelf.acgshelf.common.utils.MapperUtils;
import wang.acgshelf.acgshelf.service.sso.mapper.TbSysUserMapper;
import wang.acgshelf.acgshelf.service.sso.service.LoginService;
import wang.acgshelf.acgshelf.service.sso.service.consumer.RedisService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    public TbSysUser Login(String loginCode, String password) {
        String json = redisService.get(loginCode);

        //如果redis中没有记录
        if(json == null){
            Example example = new Example(TbSysUser.class);
            example.createCriteria().andEqualTo("loginCode", loginCode);

            TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);
            if (tbSysUser != null) {
                String encryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
                if (encryptedPassword.equals(tbSysUser.getPassword())) {
                    redisService.put(loginCode, password, 60 * 60 * 24);
                    return tbSysUser;
                }
            }
        }

        //如果redis中有记录
        else {
            try {
                return MapperUtils.json2pojo(json, TbSysUser.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}

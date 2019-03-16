package wang.acgshelf.acgshelf.service.sso.service.impl;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    public TbSysUser login(String loginCode, String password) {
        String json = redisService.get(loginCode);
        TbSysUser tbSysUser = null;

        //如果redis中没有记录
        if(json == null){
            Example example = new Example(TbSysUser.class);
            example.createCriteria().andEqualTo("loginCode", loginCode);

            tbSysUser = tbSysUserMapper.selectOneByExample(example);
            //如果获取到用户
            if (tbSysUser != null) {
                String encryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
                //如果传进来的密码加密后等于数据库里的加密密码
                if (encryptedPassword.equals(tbSysUser.getPassword())) {
                    try {
                        redisService.put(loginCode, MapperUtils.obj2json(tbSysUser), 60 * 60 * 24);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return tbSysUser;
                }
            }
        }

        //如果redis中有记录
        else {
            try {
                tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                return tbSysUser;
            } catch (Exception e) {
                logger.warn("触发熔断：{}", e.getMessage());
            }
        }

        return null;
    }
}

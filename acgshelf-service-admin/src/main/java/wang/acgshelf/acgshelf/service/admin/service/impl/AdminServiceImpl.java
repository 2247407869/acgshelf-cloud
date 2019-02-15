package wang.acgshelf.acgshelf.service.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;
import wang.acgshelf.acgshelf.service.admin.domain.TbSysUser;
import wang.acgshelf.acgshelf.service.admin.mapper.TbSysUserMapper;
import wang.acgshelf.acgshelf.service.admin.service.AdminService;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Transactional(readOnly = false)
    @Override
    public void register(TbSysUser tbSysUser) {
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String password) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode", loginCode);

        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);
        if (tbSysUser != null) {
            String encryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
            if (encryptedPassword.equals(tbSysUser.getPassword())) {
                return tbSysUser;
            }
        }
        return null;
    }
}

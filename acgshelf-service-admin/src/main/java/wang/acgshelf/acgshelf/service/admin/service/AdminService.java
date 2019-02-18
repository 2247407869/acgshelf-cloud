package wang.acgshelf.acgshelf.service.admin.service;

import wang.acgshelf.acgshelf.common.domain.TbSysUser;

public interface AdminService {

    /**
     * 注册
     * @param tbSysUser
     */
    public void register(TbSysUser tbSysUser);

    /**
     * 登录
     * @param loginCode 登录账号
     * @param password 登录密码
     * @return
     */
    public TbSysUser login(String loginCode, String password);
}

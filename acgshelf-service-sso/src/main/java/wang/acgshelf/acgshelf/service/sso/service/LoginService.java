package wang.acgshelf.acgshelf.service.sso.service;

import wang.acgshelf.acgshelf.common.domain.TbSysUser;

public interface LoginService {
    public TbSysUser Login(String loginCode, String password);
}

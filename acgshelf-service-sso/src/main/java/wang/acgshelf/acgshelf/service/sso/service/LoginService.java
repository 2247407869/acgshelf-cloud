package wang.acgshelf.acgshelf.service.sso.service;

import wang.acgshelf.acgshelf.common.domain.TbSysUser;

public interface LoginService {
    public TbSysUser login(String loginCode, String password);
}

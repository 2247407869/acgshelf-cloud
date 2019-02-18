package wang.acgshelf.acgshelf.service.sso.controller;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wang.acgshelf.acgshelf.common.domain.TbSysUser;
import wang.acgshelf.acgshelf.common.dto.BaseResult;
import wang.acgshelf.acgshelf.service.sso.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param loginCode
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public BaseResult login(String loginCode, String password) {
        BaseResult baseResult = checkLogin(loginCode, password);
        if (baseResult != null) {
            return baseResult;
        }
        TbSysUser tbSysUser = loginService.login(loginCode, password);
        if (tbSysUser != null) {
            return BaseResult.ok(tbSysUser);
        } else {
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("", "登录失败")));
        }

    }

    /**
     * 登录检查
     * @param loginCode
     * @param password
     * @return
     */
    private BaseResult checkLogin(String loginCode, String password) {
        BaseResult baseResult = null;
        if (StringUtils.isBlank(loginCode) || StringUtils.isBlank(password)) {
            baseResult = BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("loginCode", "登录账户不能为空"),
                    new BaseResult.Error("password", "密码不能为空")
            ));
        }
        return baseResult;
    }
}

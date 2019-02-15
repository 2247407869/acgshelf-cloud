package wang.acgshelf.acgshelf.service.admin.controller;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wang.acgshelf.acgshelf.common.dto.BaseResult;
import wang.acgshelf.acgshelf.service.admin.domain.TbSysUser;
import wang.acgshelf.acgshelf.service.admin.service.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

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
        TbSysUser tbSysUser = adminService.login(loginCode, password);
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

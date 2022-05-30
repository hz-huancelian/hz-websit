package com.hz.websit.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WUser;
import com.hz.websit.service.IWUserService;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WServerCustomerVo;
import com.hz.websit.vo.WUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@Controller
@RequestMapping("/wUser")
public class WUserController {

    @Autowired
    private IWUserService userService;
    /**
     * 用户登陆
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> userLogin(@RequestBody WUserVo userVo) {
        WUser user = userService.getOne(Wrappers.<WUser>lambdaQuery()
                .eq(WUser::getUsername, userVo.getUsername())
                .eq(WUser::getPassword, userVo.getPassword()));
        if(user != null && user.getId() > 0) {
            return ResultUtil.success("登陆成功");
        } else {
            return ResultUtil.error("登陆失败");
        }
    }


    /**
     * 密码修改
     * @return
     */
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> userUpdatePassword(@RequestBody WUserVo userVo) {
        userService.update(Wrappers.<WUser>lambdaUpdate().set(WUser::getPassword, userVo.getPassword()).eq(WUser::getUsername, userVo.getUsername()));
        return ResultUtil.success("修改成功");
    }
}


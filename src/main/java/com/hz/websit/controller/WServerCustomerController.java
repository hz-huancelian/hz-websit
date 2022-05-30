package com.hz.websit.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.websit.common.PageVo;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WServerCustomer;
import com.hz.websit.service.IWServerCustomerService;
import com.hz.websit.util.PageUtil;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WServerCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@RestController
@RequestMapping("/wServerCustomer")
public class WServerCustomerController {

    @Autowired
    private IWServerCustomerService iwServerCustomerService;


    /**
     * 获取展示客户列表信息-官网用
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.GET)
    public Result<Page<WServerCustomerVo>> findPageList(@ModelAttribute PageVo pageVo) {
        Page<WServerCustomerVo> page = PageUtil.initMpPage(pageVo);
        iwServerCustomerService.findPageList(page);
        return ResultUtil.data(page);
    }

    /**
     * 获取展示客户列表信息-官网用
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.GET)
    public Result<List<WServerCustomer>> findList() {
        List<WServerCustomer> ServerCustomers = iwServerCustomerService.list(Wrappers.<WServerCustomer>lambdaQuery()
                .eq(WServerCustomer::getDelFlag, '0').orderByAsc(WServerCustomer::getSort));
        return ResultUtil.data(ServerCustomers);
    }

    /**
     * 新增客户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> saveServerCustomer(@RequestBody WServerCustomerVo serverCustomerVo) {
        return iwServerCustomerService.saveServerCustomer(serverCustomerVo);
    }

    /**
     * 修改客户信息
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> updateServerCustomer(@RequestBody WServerCustomerVo serverCustomerVo) {
        return iwServerCustomerService.updateServerCustomer(serverCustomerVo);
    }

    /**
     * 删除登记客户信息
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Object> delServerCustomer(@PathVariable Long id) {
        return iwServerCustomerService.delServerCustomer(id);
    }
}


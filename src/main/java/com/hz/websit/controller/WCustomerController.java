package com.hz.websit.controller;



import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.websit.common.PageVo;
import com.hz.websit.common.Result;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hz.websit.entity.WCustomer;
import com.hz.websit.service.IWCustomerService;
import com.hz.websit.util.PageUtil;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WCusSearchVo;
import com.hz.websit.vo.WCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("/wCustomer")
public class WCustomerController {

    @Autowired
    private IWCustomerService wCustomerService;

    /**
     * 获取展示客户列表信息-官网用
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.GET)
    public Result<Page<WCustomerVo>> findPageList(@ModelAttribute WCusSearchVo cusSearchVo,
                                                  @ModelAttribute PageVo pageVo) {
        cusSearchVo.setTitle(StrUtil.trimToNull(cusSearchVo.getTitle()));
        Page<WCustomerVo> page = PageUtil.initMpPage(pageVo);
        wCustomerService.findPageList(page, cusSearchVo);
        return ResultUtil.data(page);
    }

    /**
     * 获取展示客户列表信息-官网用
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.GET)
    public Result<List<WCustomer>> findList() {
        List<WCustomer> customers = wCustomerService.list(Wrappers.<WCustomer>lambdaQuery()
                .eq(WCustomer::getDelFlag, '0').orderByAsc(WCustomer::getSort));
        return ResultUtil.data(customers);
    }

    /**
     * 新增客户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> saveCustomer(@RequestBody WCustomerVo customerVo) {
        return wCustomerService.saveCustomer(customerVo);
    }

    /**
     * 修改客户信息
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> updateCustomer(@RequestBody WCustomerVo wCustomerVo) {
        return wCustomerService.updateCustomer(wCustomerVo);
    }

    /**
     * 删除客户信息
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result<Object> delCustomer(@PathVariable Long id) {
        return wCustomerService.delCustomer(id);
    }
}


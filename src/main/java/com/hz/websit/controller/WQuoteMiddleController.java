package com.hz.websit.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.websit.common.PageVo;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WQuoteMiddle;
import com.hz.websit.service.IWQuoteMiddleService;
import com.hz.websit.util.PageUtil;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WQuoteMiddleVo;
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
@RequestMapping("/wQuoteMiddle")
public class WQuoteMiddleController {

    @Autowired
    private IWQuoteMiddleService iwQuoteMiddleService;

    /**
     * 获取展示客户列表信息-后端管理
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.GET)
    public Result<Page<WQuoteMiddleVo>> findPageList(@ModelAttribute PageVo pageVo) {
        Page<WQuoteMiddleVo> page = PageUtil.initMpPage(pageVo);
        iwQuoteMiddleService.findPageList(page);
        return ResultUtil.data(page);
    }

    /**
     * 获取展示客户列表信息-官网用
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.GET)
    public Result<List<WQuoteMiddle>> findList() {
        List<WQuoteMiddle> customers = iwQuoteMiddleService.list(Wrappers.<WQuoteMiddle>lambdaQuery()
                .eq(WQuoteMiddle::getDelFlag, '0').orderByAsc(WQuoteMiddle::getSort));
        return ResultUtil.data(customers);
    }

    /**
     * 新增客户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> saveCustomer(@RequestBody WQuoteMiddleVo quoteMiddleVo) {
        return iwQuoteMiddleService.savequoteMiddle(quoteMiddleVo);
    }

    /**
     * 修改客户信息
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> updateCustomer(@RequestBody WQuoteMiddleVo quoteMiddleVo) {
        return iwQuoteMiddleService.updatequoteMiddle(quoteMiddleVo);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Object> deleteCustomer(@PathVariable Long id) {
        return iwQuoteMiddleService.delquoteMiddle(id);
    }

}


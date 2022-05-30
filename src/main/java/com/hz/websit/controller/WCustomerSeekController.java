package com.hz.websit.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.websit.common.PageVo;
import com.hz.websit.common.Result;
import com.hz.websit.service.IWCustomerSeekService;
import com.hz.websit.util.PageUtil;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WCusSearchVo;
import com.hz.websit.vo.WCusSeekSearchVo;
import com.hz.websit.vo.WCusSeekVo;
import com.hz.websit.vo.WCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@RestController
@RequestMapping("/wCustomerSeek")
public class WCustomerSeekController {

    @Autowired
    private IWCustomerSeekService customerSeekService;

    /**
     * 管理后台获取登记用户列表
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.GET)
    public Result<Page<WCusSeekVo>> findPageList(@ModelAttribute WCusSeekSearchVo cusSeekSearchVo,
                                                 @ModelAttribute PageVo pageVo) {
        cusSeekSearchVo.setOrganName(StrUtil.trimToNull(cusSeekSearchVo.getOrganName()));
        cusSeekSearchVo.setOrganNo(StrUtil.trimToNull(cusSeekSearchVo.getOrganNo()));

        Page<WCusSeekVo> page = PageUtil.initMpPage(pageVo);
        customerSeekService.findPageList(page, cusSeekSearchVo);
        return ResultUtil.data(page);
    }

    /**
     * 新增登记客户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> saveCusSeek(@RequestBody WCusSeekVo cusSeekVo) {
        return customerSeekService.saveCusSeek(cusSeekVo);
    }


    /**
     * 删除登记客户信息
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Object> delCusSeek(@PathVariable Long id) {
        return customerSeekService.delCusSeek(id);
    }

}


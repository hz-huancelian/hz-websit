package com.hz.websit.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.websit.common.PageVo;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WQuoteBottom;
import com.hz.websit.service.IWQuoteBottomService;
import com.hz.websit.util.PageUtil;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WQuoteBottomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 * 首页第二个swpier功能需求
 * @author gzh
 * @since 2021-08-22
 */
@RestController
@RequestMapping("/wQuoteBottom")
public class WQuoteBottomController {

    @Autowired
    private IWQuoteBottomService iwQuoteBottomService;


    /**
     * 获取展示客户列表信息-官网用
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.GET)
    public Result<Page<WQuoteBottomVo>> findPageList(@ModelAttribute PageVo pageVo) {
        Page<WQuoteBottomVo> page = PageUtil.initMpPage(pageVo);
        iwQuoteBottomService.findPageList(page);
        return ResultUtil.data(page);
    }

    /**
     * 获取展示客户列表信息-官网用
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.GET)
    public Result<List<WQuoteBottom>> findList() {
        List<WQuoteBottom> QuoteBottoms = iwQuoteBottomService.list(Wrappers.<WQuoteBottom>lambdaQuery()
                .eq(WQuoteBottom::getDelFlag, '0').orderByAsc(WQuoteBottom::getSort));
        return ResultUtil.data(QuoteBottoms);
    }

    /**
     * 新增客户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> saveQuoteBottom(@RequestBody WQuoteBottomVo quoteBottomVo) {
        return iwQuoteBottomService.saveQuoteBottom(quoteBottomVo);
    }

    /**
     * 修改客户信息
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> updateQuoteBottom(@RequestBody WQuoteBottomVo quoteBottomVo) {
        return iwQuoteBottomService.updateQuoteBottom(quoteBottomVo);
    }
    
    /**
     * 删除登记客户信息
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Object> delQuoteBottom(@PathVariable Long id) {
        return iwQuoteBottomService.delQuoteBottom(id);
    }

}


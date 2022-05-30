package com.hz.websit.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WAdver;
import com.hz.websit.service.IWAdverService;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WAdverVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 *  广告信息管理
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@RestController
@RequestMapping("/wAdver")
public class WAdverController {

    @Autowired
    private IWAdverService iwAdverService;

    /**
     * 获取展示客户列表信息-官网用
     *
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.GET)
    public Result<List<WAdver>> findList() {
        List<WAdver> advers = iwAdverService.list(Wrappers.<WAdver>lambdaQuery()
                .eq(WAdver::getDelFlag, '0'));
        return ResultUtil.data(advers);
    }

    /**
     * 获取广告信息-官网用
     *
     * @return
     */
    @RequestMapping(value = "findShowIndex", method = RequestMethod.GET)
    public Result<WAdverVo> findShowIndex() {
        WAdverVo vo = iwAdverService.findShowIndex();
        return ResultUtil.data(vo);
    }

    /**
     * 新增客户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> saveAdver(@RequestBody WAdverVo adverVo) {
        return iwAdverService.saveAdver(adverVo);
    }

    /**
     * 修改客户信息
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> updateAdver(@RequestBody WAdverVo adverVo) {
        return iwAdverService.updateAdver(adverVo);
    }

    /**
     * 删除客户信息
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result<Object> delAdver(@PathVariable Long id) {
        return iwAdverService.delAdver(id);
    }

}



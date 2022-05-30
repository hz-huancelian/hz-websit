package com.hz.websit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WQuoteMiddle;
import com.hz.websit.entity.WQuoteMiddle;
import com.hz.websit.entity.WQuoteMiddle;
import com.hz.websit.mapper.WQuoteMiddleMapper;
import com.hz.websit.service.IWQuoteMiddleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WQuoteMiddleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@Service
public class WQuoteMiddleServiceImpl extends ServiceImpl<WQuoteMiddleMapper, WQuoteMiddle> implements IWQuoteMiddleService {

    @Autowired
    private WQuoteMiddleMapper wQuoteMiddleMapper;

    @Override
    public IPage<WQuoteMiddleVo> findPageList(IPage<WQuoteMiddleVo> page) {
        return this.wQuoteMiddleMapper.findListByCondition(page);
    }

    @Override
    public Result<Object> savequoteMiddle(WQuoteMiddleVo quoteMiddleVo) {
        LocalDateTime now = LocalDateTime.now();
        WQuoteMiddle quoteMiddle = new WQuoteMiddle();
        quoteMiddle.setTitle(quoteMiddleVo.getTitle())
                .setImgUrl(quoteMiddleVo.getImgUrl())
                .setVideoUrl(quoteMiddleVo.getVideoUrl())
                .setContent(quoteMiddleVo.getContent())
                .setSort(quoteMiddleVo.getSort())
                .setDelFlag(0)
                .setCreateTime(now)
                .setUpdateTime(now);
        int res = wQuoteMiddleMapper.insert(quoteMiddle);
        if(res != 0) {
            return ResultUtil.success("新增成功！");
        } else {
            return ResultUtil.error("新增失败！");
        }
    }

    @Override
    public Result<Object> updatequoteMiddle(WQuoteMiddleVo quoteMiddleVo) {
        LocalDateTime now = LocalDateTime.now();
        WQuoteMiddle quoteMiddle = new WQuoteMiddle();
        quoteMiddle.setTitle(quoteMiddleVo.getTitle())
                .setImgUrl(quoteMiddleVo.getImgUrl())
                .setVideoUrl(quoteMiddleVo.getVideoUrl())
                .setContent(quoteMiddleVo.getContent())
                .setSort(quoteMiddleVo.getSort())
                .setId(quoteMiddleVo.getId())
                .setUpdateTime(now);
        int res = wQuoteMiddleMapper.updateById(quoteMiddle);
        if(res > 0) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.error("修改失败！");
        }
    }

    @Override
    public Result<Object> delquoteMiddle(Long id) {
        wQuoteMiddleMapper.deleteById(id);
        return  ResultUtil.success("删除成功！");
    }
}

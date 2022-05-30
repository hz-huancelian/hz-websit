package com.hz.websit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WQuoteBottom;
import com.hz.websit.mapper.WQuoteBottomMapper;
import com.hz.websit.service.IWQuoteBottomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WQuoteBottomVo;
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
public class WQuoteBottomServiceImpl extends ServiceImpl<WQuoteBottomMapper, WQuoteBottom> implements IWQuoteBottomService {

    @Autowired
    private WQuoteBottomMapper quoteBottomMapper;

    @Override
    public IPage<WQuoteBottomVo> findPageList(IPage<WQuoteBottomVo> page) {
        return this.quoteBottomMapper.findListByCondition(page);
    }

    @Override
    public Result<Object> saveQuoteBottom(WQuoteBottomVo quoteBottomVo) {
        LocalDateTime now = LocalDateTime.now();
        WQuoteBottom quoteBottom = new WQuoteBottom();
        quoteBottom.setTitle(quoteBottomVo.getTitle())
                .setImgUrl(quoteBottomVo.getImgUrl())
                .setLogo(quoteBottomVo.getLogo())
                .setContent(quoteBottomVo.getContent())
                .setBottomSign(quoteBottomVo.getBottomSign())
                .setSort(quoteBottomVo.getSort())
                .setDelFlag(0)
                .setCreateTime(now)
                .setUpdateTime(now);
        int res = quoteBottomMapper.insert(quoteBottom);
        if(res != 0) {
            return ResultUtil.success("新增成功！");
        } else {
            return ResultUtil.error("新增失败！");
        }
    }

    @Override
    public Result<Object> updateQuoteBottom(WQuoteBottomVo quoteBottomVo) {
        LocalDateTime now = LocalDateTime.now();
        WQuoteBottom quoteBottom = new WQuoteBottom();
        quoteBottom.setTitle(quoteBottomVo.getTitle())
                .setImgUrl(quoteBottomVo.getImgUrl())
                .setLogo(quoteBottomVo.getLogo())
                .setContent(quoteBottomVo.getContent())
                .setBottomSign(quoteBottomVo.getBottomSign())
                .setSort(quoteBottomVo.getSort())
                .setId(quoteBottomVo.getId())
                .setUpdateTime(now);
        int res = quoteBottomMapper.updateById(quoteBottom);
        if(res > 0) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.error("修改失败！");
        }
    }

    @Override
    public Result<Object> delQuoteBottom(Long id) {
        quoteBottomMapper.deleteById(id);
        return  ResultUtil.success("删除成功！");
    }
}

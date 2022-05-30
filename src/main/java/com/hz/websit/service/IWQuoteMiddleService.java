package com.hz.websit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WQuoteMiddle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.websit.vo.WQuoteMiddleVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
public interface IWQuoteMiddleService extends IService<WQuoteMiddle> {

    IPage<WQuoteMiddleVo> findPageList(IPage<WQuoteMiddleVo> page);

    Result<Object> savequoteMiddle(WQuoteMiddleVo quoteMiddleVo);

    Result<Object> updatequoteMiddle(WQuoteMiddleVo quoteMiddleVo);

    Result<Object> delquoteMiddle(Long id);
}

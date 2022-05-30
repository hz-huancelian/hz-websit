package com.hz.websit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WQuoteBottom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.websit.vo.WCusSearchVo;
import com.hz.websit.vo.WQuoteBottomVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
public interface IWQuoteBottomService extends IService<WQuoteBottom> {

    IPage<WQuoteBottomVo> findPageList(IPage<WQuoteBottomVo> page);

    Result<Object> saveQuoteBottom(WQuoteBottomVo quoteBottomVo);

    Result<Object> updateQuoteBottom(WQuoteBottomVo quoteBottomVo);

    Result<Object> delQuoteBottom(Long id);
}

package com.hz.websit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.websit.entity.WCustomerSeek;
import com.hz.websit.vo.WCusSeekSearchVo;
import com.hz.websit.vo.WCusSeekVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
public interface IWCustomerSeekService extends IService<WCustomerSeek> {

    IPage<WCusSeekVo> findPageList(IPage<WCusSeekVo> page, WCusSeekSearchVo cusSeekSearchVo);

    Result<Object> saveCusSeek(WCusSeekVo cusSeekVo);

    Result<Object> delCusSeek(Long id);
}

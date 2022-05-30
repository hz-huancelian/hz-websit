package com.hz.websit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WCustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.websit.vo.WCusSearchVo;
import com.hz.websit.vo.WCustomerVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
public interface IWCustomerService extends IService<WCustomer> {

    IPage<WCustomerVo> findPageList(IPage<WCustomerVo> page, WCusSearchVo cusSearchVo);

    Result<Object> saveCustomer(WCustomerVo customerVo);

    Result<Object> updateCustomer(WCustomerVo customerVo);

    Result<Object> delCustomer(Long id);
}

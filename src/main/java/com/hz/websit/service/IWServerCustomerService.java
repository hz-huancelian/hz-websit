package com.hz.websit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WServerCustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.websit.vo.WServerCustomerVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
public interface IWServerCustomerService extends IService<WServerCustomer> {

    IPage<WServerCustomerVo> findPageList(IPage<WServerCustomerVo> page);

    Result<Object> saveServerCustomer(WServerCustomerVo serverCustomerVo);

    Result<Object> updateServerCustomer(WServerCustomerVo serverCustomerVo);

    Result<Object> delServerCustomer(Long id);
}

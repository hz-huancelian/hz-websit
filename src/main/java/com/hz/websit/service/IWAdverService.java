package com.hz.websit.service;

import com.hz.websit.common.Result;
import com.hz.websit.entity.WAdver;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.websit.vo.WAdverVo;
import com.hz.websit.vo.WCustomerVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
public interface IWAdverService extends IService<WAdver> {

    WAdverVo findShowIndex();

    Result<Object> saveAdver(WAdverVo wAdverVo);

    Result<Object> updateAdver(WAdverVo wAdverVo);

    Result<Object> delAdver(Long id);
}

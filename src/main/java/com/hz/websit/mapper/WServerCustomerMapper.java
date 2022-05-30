package com.hz.websit.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.entity.WServerCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.websit.vo.WServerCustomerVo;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@Repository
public interface WServerCustomerMapper extends BaseMapper<WServerCustomer> {

    IPage<WServerCustomerVo> findListByCondition(IPage<WServerCustomerVo> page);
}

package com.hz.websit.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.entity.WQuoteBottom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.websit.vo.WCusSearchVo;
import com.hz.websit.vo.WCustomerVo;
import com.hz.websit.vo.WQuoteBottomVo;
import org.apache.ibatis.annotations.Param;
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
public interface WQuoteBottomMapper extends BaseMapper<WQuoteBottom> {

    IPage<WQuoteBottomVo> findListByCondition(IPage<WQuoteBottomVo> page);
}

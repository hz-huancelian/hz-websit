package com.hz.websit.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.entity.WCustomerSeek;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.websit.vo.WCusSeekSearchVo;
import com.hz.websit.vo.WCusSeekVo;
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
public interface WCustomerSeekMapper extends BaseMapper<WCustomerSeek> {

    IPage<WCusSeekVo> findListByCondition(IPage<WCusSeekVo> page, @Param("cs") WCusSeekSearchVo vo);

}

package com.hz.websit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.entity.SysDictRoot;
import com.hz.websit.vo.SysDictRootVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDictRootMapper extends BaseMapper<SysDictRoot> {


    IPage<SysDictRootVo> findPageByCondition(IPage<SysDictRootVo> page, @Param("dictVal") String dictVal);
}

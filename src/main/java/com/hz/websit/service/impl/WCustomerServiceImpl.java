package com.hz.websit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WCustomer;
import com.hz.websit.mapper.WCustomerMapper;
import com.hz.websit.service.IWCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WCusSearchVo;
import com.hz.websit.vo.WCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@Service
public class WCustomerServiceImpl extends ServiceImpl<WCustomerMapper, WCustomer> implements IWCustomerService {

    @Autowired
    private WCustomerMapper customerMapper;

    @Override
    public IPage<WCustomerVo> findPageList(IPage<WCustomerVo> page, WCusSearchVo cusSearchVo) {
        return this.customerMapper.findListByCondition(page, cusSearchVo);
    }

    @Override
    public Result<Object> saveCustomer(WCustomerVo customerVo) {
        LocalDateTime now = LocalDateTime.now();
        WCustomer customer = new WCustomer();
        customer.setBigImgUrl(customerVo.getBigImgUrl())
                .setContent(customerVo.getContent())
                .setImgUrl(customerVo.getImgUrl())
                .setBigImgUrl(customerVo.getBigImgUrl())
                .setTitle(customerVo.getTitle())
                .setSort(customerVo.getSort())
                .setDelFlag(0)
                .setCreateTime(now)
                .setUpdateTime(now)
                .setLogo(customerVo.getLogo());
        int res = customerMapper.insert(customer);
        if(res != 0) {
            return ResultUtil.success("新增成功！");
        } else {
            return ResultUtil.error("新增失败！");
        }
    }

    @Override
    public Result<Object> updateCustomer(WCustomerVo customerVo) {
        LocalDateTime now = LocalDateTime.now();
        WCustomer customer = new WCustomer();
        customer.setBigImgUrl(customerVo.getBigImgUrl())
                .setContent(customerVo.getContent())
                .setImgUrl(customerVo.getImgUrl())
                .setBigImgUrl(customerVo.getBigImgUrl())
                .setTitle(customerVo.getTitle())
                .setSort(customerVo.getSort())
                .setId(customerVo.getId())
                .setUpdateTime(now)
                .setLogo(customerVo.getLogo());
        int res = customerMapper.updateById(customer);
        if(res > 0) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.error("修改失败！");
        }
    }

    @Override
    public Result<Object> delCustomer(Long id) {
        customerMapper.deleteById(id);
        return  ResultUtil.success("删除成功！");
    }
}

package com.hz.websit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WServerCustomer;
import com.hz.websit.entity.WServerCustomer;
import com.hz.websit.mapper.WServerCustomerMapper;
import com.hz.websit.mapper.WServerCustomerMapper;
import com.hz.websit.service.IWServerCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WServerCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@Service
public class WServerCustomerServiceImpl extends ServiceImpl<WServerCustomerMapper, WServerCustomer> implements IWServerCustomerService {

    @Autowired
    private WServerCustomerMapper serverCustomerMapper;

    @Override
    public IPage<WServerCustomerVo> findPageList(IPage<WServerCustomerVo> page) {

        return this.serverCustomerMapper.findListByCondition(page);
    }

    @Override
    public Result<Object> saveServerCustomer(WServerCustomerVo serverCustomerVo) {
        LocalDateTime now = LocalDateTime.now();
        WServerCustomer serverCustomer = new WServerCustomer();
        serverCustomer.setTitle(serverCustomerVo.getTitle())
                .setImgUrl(serverCustomerVo.getImgUrl())
                .setLogo(serverCustomerVo.getLogo())
                .setServerType(serverCustomerVo.getServerType())
                .setRouterUrl(serverCustomerVo.getRouterUrl())
                .setEnterName(serverCustomerVo.getEnterName())
                .setServerDesc(serverCustomerVo.getServerDesc())
                .setContent(serverCustomerVo.getContent())
                .setComment(serverCustomerVo.getComment())
                .setDescSign(serverCustomerVo.getDescSign())
                .setSort(serverCustomerVo.getSort())
                .setDelFlag(0)
                .setCreateTime(now)
                .setUpdateTime(now);
        int res = serverCustomerMapper.insert(serverCustomer);
        if(res != 0) {
            return ResultUtil.success("新增成功！");
        } else {
            return ResultUtil.error("新增失败！");
        }
    }

    @Override
    public Result<Object> updateServerCustomer(WServerCustomerVo serverCustomerVo) {
        LocalDateTime now = LocalDateTime.now();
        WServerCustomer serverCustomer = new WServerCustomer();
        serverCustomer.setId(serverCustomerVo.getId())
                .setTitle(serverCustomerVo.getTitle())
                .setImgUrl(serverCustomerVo.getImgUrl())
                .setLogo(serverCustomerVo.getLogo())
                .setServerType(serverCustomerVo.getServerType())
                .setRouterUrl(serverCustomerVo.getRouterUrl())
                .setEnterName(serverCustomerVo.getEnterName())
                .setServerDesc(serverCustomerVo.getServerDesc())
                .setContent(serverCustomerVo.getContent())
                .setComment(serverCustomerVo.getComment())
                .setDescSign(serverCustomerVo.getDescSign())
                .setSort(serverCustomerVo.getSort())
                .setUpdateTime(now);
        int res = serverCustomerMapper.updateById(serverCustomer);
        if(res > 0) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.error("修改失败！");
        }
    }

    @Override
    public Result<Object> delServerCustomer(Long id) {
        serverCustomerMapper.deleteById(id);
        return  ResultUtil.success("删除成功！");
    }
    
}

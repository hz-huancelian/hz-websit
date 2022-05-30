package com.hz.websit.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WAdver;
import com.hz.websit.entity.WCustomer;
import com.hz.websit.mapper.WAdverMapper;
import com.hz.websit.service.IWAdverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WAdverVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class WAdverServiceImpl extends ServiceImpl<WAdverMapper, WAdver> implements IWAdverService {

    @Autowired
    private WAdverMapper wAdverMapper;

    @Override
    public WAdverVo findShowIndex() {
        WAdver wAdver = wAdverMapper.selectOne(Wrappers.<WAdver>lambdaQuery().eq(WAdver::getShowPage, '0').last("limit 0,1"));
        WAdverVo wAdverVo = new WAdverVo();
        wAdverVo.setId(wAdver.getId())
                .setContent(wAdver.getContent())
                .setImgUrl(wAdver.getImgUrl())
                .setRouterUrl(wAdver.getRouterUrl())
                .setTitle(wAdver.getTitle());
        return wAdverVo;
    }

    @Transactional
    @Override
    public Result<Object> saveAdver(WAdverVo wAdverVo) {
        LocalDateTime now = LocalDateTime.now();
        if(wAdverVo.getShowPage() == 0) { // 取消其他广告的前端展示
           this.update(Wrappers.<WAdver>lambdaUpdate().set(WAdver::getShowPage, 1));
        }
        WAdver adver = new WAdver();
        adver.setImgUrl(wAdverVo.getImgUrl())
                .setContent(wAdverVo.getContent())
                .setRouterUrl(wAdverVo.getRouterUrl())
                .setShowPage(wAdverVo.getShowPage())
                .setDelFlag(0)
                .setCreateTime(now)
                .setUpdateTime(now)
                .setTitle(wAdverVo.getTitle());
        int res = wAdverMapper.insert(adver);
        if(res != 0) {
            return ResultUtil.success("新增成功！");
        } else {
            return ResultUtil.error("新增失败！");
        }
    }

    @Override
    public Result<Object> updateAdver(WAdverVo wAdverVo) {
        LocalDateTime now = LocalDateTime.now();
        if(wAdverVo.getShowPage() == 0) { // 取消其他广告的前端展示
            this.update(Wrappers.<WAdver>lambdaUpdate().set(WAdver::getShowPage, 1));
        }
        WAdver adver = new WAdver();
        adver.setImgUrl(wAdverVo.getImgUrl())
                .setId(wAdverVo.getId())
                .setContent(wAdverVo.getContent())
                .setRouterUrl(wAdverVo.getRouterUrl())
                .setShowPage(wAdverVo.getShowPage())
                .setUpdateTime(now)
                .setTitle(wAdverVo.getTitle());
        int res = wAdverMapper.updateById(adver);
        if(res > 0) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.error("修改失败！");
        }
    }

    @Override
    public Result<Object> delAdver(Long id) {
        wAdverMapper.deleteById(id);
        return  ResultUtil.success("删除成功！");
    }
}

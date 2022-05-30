package com.hz.websit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.websit.common.Result;
import com.hz.websit.entity.WCustomerSeek;
import com.hz.websit.mapper.WCustomerSeekMapper;
import com.hz.websit.service.IWCustomerSeekService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.websit.util.ResultUtil;
import com.hz.websit.vo.WCusSeekSearchVo;
import com.hz.websit.vo.WCusSeekVo;
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
public class WCustomerSeekServiceImpl extends ServiceImpl<WCustomerSeekMapper, WCustomerSeek> implements IWCustomerSeekService {

    @Autowired
    private WCustomerSeekMapper customerSeekMapper;

    @Override
    public IPage<WCusSeekVo> findPageList(IPage<WCusSeekVo> page, WCusSeekSearchVo cusSeekSearchVo) {
        return this.customerSeekMapper.findListByCondition(page, cusSeekSearchVo);
    }

    @Override
    public Result<Object> saveCusSeek(WCusSeekVo cusSeekVo) {
        LocalDateTime now = LocalDateTime.now();
        WCustomerSeek customerSeek = new WCustomerSeek();
        customerSeek.setOrganName(cusSeekVo.getOrganName())
                .setOrganNo(cusSeekVo.getOrganNo())
                .setOrganLegal(cusSeekVo.getOrganLegal())
                .setEmail(cusSeekVo.getEmail())
                .setLink(cusSeekVo.getLink())
                .setPhone(cusSeekVo.getPhone())
                .setDelFlag(0)
                .setCreateTime(now)
                .setUpdateTime(now);
        int res = customerSeekMapper.insert(customerSeek);
        if(res != 0) {
            // 新增成功-进行邮件发送
            sendEmail(customerSeek);
            return ResultUtil.success("新增成功！");
        } else {
            return ResultUtil.error("新增失败！");
        }
    }


    @Override
    public Result<Object> delCusSeek(Long id) {
        customerSeekMapper.deleteById(id);
        return  ResultUtil.success("删除成功！");
    }

    public void sendEmail(WCustomerSeek customerSeek) {

    }
}

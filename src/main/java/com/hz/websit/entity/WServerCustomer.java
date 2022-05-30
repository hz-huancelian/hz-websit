package com.hz.websit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("w_server_customer")
public class WServerCustomer extends Model<WServerCustomer> {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * swiper图片
     */
    @TableField("imgUrl")
    private String imgUrl;

    /**
     * 企业logo
     */
    private String logo;

    /**
     * 外链地址
     */
    @TableField("routerUrl")
    private String routerUrl;

    /**
     * 企业名称
     */
    private String enterName;

    /**
     * 企业分类
     */
    @TableField("server_type")
    private String serverType;

    /**
     * 标题
     */
    private String title;

    /**
     * 公司描述
     */
    @TableField("server_desc")
    private String serverDesc;

    /**
     * 描述信息落款
     */
    @TableField("desc_sign")
    private String descSign;

    /**
     * 内容体
     */
    private String content;

    /**
     * 评论信息
     */
    private String comment;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 删除标识
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

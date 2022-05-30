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
@TableName("w_adver")
public class WAdver extends Model<WAdver> {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * swiper图片
     */
    @TableField("imgUrl")
    private String imgUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容体
     */
    private String content;

    /**
     * 外链地址
     */
    @TableField("routerUrl")
    private String routerUrl;

    /**
     * 是否官网显示-每次只显示一条-以后拓展
     */
    @TableField("show_page")
    private Integer showPage;

    /**
     * 排序标记
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

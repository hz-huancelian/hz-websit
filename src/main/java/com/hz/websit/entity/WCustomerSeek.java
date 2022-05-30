package com.hz.websit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
@TableName("w_customer_seek")
public class WCustomerSeek extends Model<WCustomerSeek> {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 机构名称
     */
    private String organName;

    /**
     * 机构代码
     */
    private String organNo;

    /**
     * 机构法人
     */
    private String organLegal;

    /**
     * 联系人
     */
    private String link;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

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

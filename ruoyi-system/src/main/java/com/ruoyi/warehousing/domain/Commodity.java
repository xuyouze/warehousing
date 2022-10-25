package com.ruoyi.warehousing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * commodity对象 commodity
 *
 * @author youze.xu
 * @date 2022-10-19
 */
public class Commodity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @Excel(name = "商品ID", sort = 0)
    private Long cId;

    /**
     * 商品名
     */
    @Excel(name = "商品名", sort = 1)
    private String commodityName;

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getcId() {
        return cId;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("cId", getcId())
                .append("commodityName", getCommodityName())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}

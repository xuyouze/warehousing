package com.ruoyi.warehousing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * manufacturer对象 manufacturer
 * 
 * @author youze.xu
 * @date 2022-10-23
 */
public class Manufacturer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 厂家ID */
    private Long mId;

    /** 厂家名 */
    @Excel(name = "厂家名")
    private String manufacturerName;

    public void setmId(Long mId) 
    {
        this.mId = mId;
    }

    public Long getmId() 
    {
        return mId;
    }
    public void setManufacturerName(String manufacturerName) 
    {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() 
    {
        return manufacturerName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mId", getmId())
            .append("manufacturerName", getManufacturerName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

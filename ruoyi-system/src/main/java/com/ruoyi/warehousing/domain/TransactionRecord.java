package com.ruoyi.warehousing.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * transaction_record对象 transaction_record
 * 
 * @author ruoyi
 * @date 2022-10-25
 */
public class TransactionRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 交易记录ID */
    private Long trId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long cId;

    @Excel(name = "商品名")
    private String commodityName;

    /** 厂家ID */
    @Excel(name = "厂家ID")
    private Long mId;

    @Excel(name = "厂家名")
    private String manufacturerName;

    /** 交易单ID */
    @Excel(name = "交易单ID")
    private Long tId;

    /** 数量 */
    @Excel(name = "数量")
    private Long amount;

    /** 交易日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交易日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tDate;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 颜色 */
    @Excel(name = "颜色")
    private String color;

    /** 是否入库 */
    @Excel(name = "操作状态", readConverterExp = "0=出库,1=入库")
    private String inOrOut;

    public void setTrId(Long trId) 
    {
        this.trId = trId;
    }

    public Long getTrId() 
    {
        return trId;
    }
    public void setcId(Long cId) 
    {
        this.cId = cId;
    }

    public Long getcId() 
    {
        return cId;
    }
    public void setmId(Long mId) 
    {
        this.mId = mId;
    }

    public Long getmId() 
    {
        return mId;
    }
    public void settId(Long tId) 
    {
        this.tId = tId;
    }

    public Long gettId() 
    {
        return tId;
    }
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }
    public void settDate(Date tDate) 
    {
        this.tDate = tDate;
    }

    public Date gettDate() 
    {
        return tDate;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("trId", getTrId())
            .append("cId", getcId())
            .append("mId", getmId())
            .append("tId", gettId())
            .append("amount", getAmount())
            .append("tDate", gettDate())
            .append("unit", getUnit())
            .append("color", getColor())
            .append("inOrOut", getInOrOut())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

package com.ruoyi.warehousing.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * TransactionRecordStatistics对象
 * 
 * @author youze.xu
 * @date 2022-10-25
 */
public class TransactionRecordStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

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

    /** 数量 */
    @Excel(name = "数量")
    private Long amount;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 颜色 */
    @Excel(name = "颜色")
    private String color;


    /** 颜色 */
    @Excel(name = "交易条数")
    private Long count;

    /** 是否入库 */
    @Excel(name = "操作状态", readConverterExp = "0=出库,1=入库")
    private String inOrOut;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cId", getcId())
            .append("commodityName", getCommodityName())
            .append("mId", getmId())
            .append("manufacturerName", getManufacturerName())
            .append("amount", getAmount())
            .append("unit", getUnit())
            .append("color", getColor())
            .append("inOrOut", getInOrOut())
            .append("count", getCount())
            .toString();
    }
}

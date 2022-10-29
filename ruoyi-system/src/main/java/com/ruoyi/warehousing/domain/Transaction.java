package com.ruoyi.warehousing.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * transaction对象 transaction
 *
 * @author youze.xu
 * @date 2022-10-24
 */
public class Transaction extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 交易单ID
     */
    private Long tId;

    /**
     * 厂家ID
     */
    @Excel(name = "厂家ID")
    private Long mId;

    @Excel(name = "厂家姓名")
    private String manufacturerName;

    private List<TransactionRecord> transactionRecordList;

    private String tmp;

    /**
     * 交易日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交易日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tDate;

    /**
     * 是否入库
     */
    @Excel(name = "操作状态", readConverterExp = "0=出库,1=入库")
    private String inOrOut;

    public void settId(Long tId) {
        this.tId = tId;
    }

    public Long gettId() {
        return tId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public Long getmId() {
        return mId;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public Date gettDate() {
        return tDate;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<TransactionRecord> getTransactionRecordList() {
        return transactionRecordList;
    }

    public void setTransactionRecordList(List<TransactionRecord> transactionRecordList) {
        this.transactionRecordList = transactionRecordList;
    }


    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("tId", gettId())
                .append("mId", getmId())
                .append("tDate", gettDate())
                .append("inOrOut", getInOrOut())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}

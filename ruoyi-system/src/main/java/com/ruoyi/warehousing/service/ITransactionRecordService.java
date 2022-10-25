package com.ruoyi.warehousing.service;

import java.util.List;
import com.ruoyi.warehousing.domain.TransactionRecord;

/**
 * transaction_recordService接口
 * 
 * @author ruoyi
 * @date 2022-10-25
 */
public interface ITransactionRecordService 
{
    /**
     * 查询transaction_record
     * 
     * @param trId transaction_record主键
     * @return transaction_record
     */
    public TransactionRecord selectTransactionRecordByTrId(Long trId);

    /**
     * 查询transaction_record列表
     * 
     * @param transactionRecord transaction_record
     * @return transaction_record集合
     */
    public List<TransactionRecord> selectTransactionRecordList(TransactionRecord transactionRecord);

    /**
     * 新增transaction_record
     * 
     * @param transactionRecord transaction_record
     * @return 结果
     */
    public int insertTransactionRecord(TransactionRecord transactionRecord);

    /**
     * 修改transaction_record
     * 
     * @param transactionRecord transaction_record
     * @return 结果
     */
    public int updateTransactionRecord(TransactionRecord transactionRecord);

    /**
     * 批量删除transaction_record
     * 
     * @param trIds 需要删除的transaction_record主键集合
     * @return 结果
     */
    public int deleteTransactionRecordByTrIds(String trIds);

    /**
     * 删除transaction_record信息
     * 
     * @param trId transaction_record主键
     * @return 结果
     */
    public int deleteTransactionRecordByTrId(Long trId);
}

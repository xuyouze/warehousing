package com.ruoyi.warehousing.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.warehousing.mapper.TransactionRecordMapper;
import com.ruoyi.warehousing.domain.TransactionRecord;
import com.ruoyi.warehousing.service.ITransactionRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * transaction_recordService业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-25
 */
@Service
public class TransactionRecordServiceImpl implements ITransactionRecordService 
{
    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    /**
     * 查询transaction_record
     * 
     * @param trId transaction_record主键
     * @return transaction_record
     */
    @Override
    public TransactionRecord selectTransactionRecordByTrId(Long trId)
    {
        return transactionRecordMapper.selectTransactionRecordByTrId(trId);
    }

    /**
     * 查询transaction_record列表
     * 
     * @param transactionRecord transaction_record
     * @return transaction_record
     */
    @Override
    public List<TransactionRecord> selectTransactionRecordList(TransactionRecord transactionRecord)
    {
        return transactionRecordMapper.selectTransactionRecordList(transactionRecord);
    }

    /**
     * 新增transaction_record
     * 
     * @param transactionRecord transaction_record
     * @return 结果
     */
    @Override
    public int insertTransactionRecord(TransactionRecord transactionRecord)
    {
        transactionRecord.setCreateTime(DateUtils.getNowDate());
        return transactionRecordMapper.insertTransactionRecord(transactionRecord);
    }

    /**
     * 修改transaction_record
     * 
     * @param transactionRecord transaction_record
     * @return 结果
     */
    @Override
    public int updateTransactionRecord(TransactionRecord transactionRecord)
    {
        transactionRecord.setUpdateTime(DateUtils.getNowDate());
        return transactionRecordMapper.updateTransactionRecord(transactionRecord);
    }

    /**
     * 批量删除transaction_record
     * 
     * @param trIds 需要删除的transaction_record主键
     * @return 结果
     */
    @Override
    public int deleteTransactionRecordByTrIds(String trIds)
    {
        return transactionRecordMapper.deleteTransactionRecordByTrIds(Convert.toStrArray(trIds));
    }

    /**
     * 删除transaction_record信息
     * 
     * @param trId transaction_record主键
     * @return 结果
     */
    @Override
    public int deleteTransactionRecordByTrId(Long trId)
    {
        return transactionRecordMapper.deleteTransactionRecordByTrId(trId);
    }
}

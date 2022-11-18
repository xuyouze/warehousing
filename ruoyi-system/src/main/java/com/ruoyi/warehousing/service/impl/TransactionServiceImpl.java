package com.ruoyi.warehousing.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.warehousing.domain.TransactionRecord;
import com.ruoyi.warehousing.mapper.TransactionRecordMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.warehousing.mapper.TransactionMapper;
import com.ruoyi.warehousing.domain.Transaction;
import com.ruoyi.warehousing.service.ITransactionService;
import com.ruoyi.common.core.text.Convert;

/**
 * transactionService业务层处理
 *
 * @author youze.xu
 * @date 2022-10-24
 */
@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    /**
     * 查询transaction
     *
     * @param tId transaction主键
     * @return transaction
     */
    @Override
    public Transaction selectTransactionByTId(Long tId) {
        return transactionMapper.selectTransactionByTId(tId);
    }

    /**
     * 查询transaction列表
     *
     * @param transaction transaction
     * @return transaction
     */
    @Override
    public List<Transaction> selectTransactionList(Transaction transaction) {
        return transactionMapper.selectTransactionList(transaction);
    }

    /**
     * 新增transaction
     *
     * @param transaction transaction
     * @return 结果
     */
    @Override
    public int insertTransaction(Transaction transaction) {
        transaction.setCreateTime(DateUtils.getNowDate());
        int result = transactionMapper.insertTransaction(transaction);
        List<TransactionRecord> transactionRecordList = transaction.getTransactionRecordList();
        if (transactionRecordList == null || transactionRecordList.size() == 0) {
            return 0;
        }
        for (TransactionRecord i :
                transactionRecordList) {
            BeanUtils.copyProperties(transaction, i);
            transactionRecordMapper.insertTransactionRecord(i);
        }
        return result;
    }

    /**
     * 修改transaction
     *
     * @param transaction transaction
     * @return 结果
     */
    @Override
    public int updateTransaction(Transaction transaction) {
        transaction.setUpdateTime(DateUtils.getNowDate());
        int result = transactionMapper.updateTransaction(transaction);
        List<TransactionRecord> transactionRecordList = transaction.getTransactionRecordList();
        if (transactionRecordList == null || transactionRecordList.size() == 0) {
            return 0;
        }
        for (TransactionRecord i :
                transactionRecordList) {
            BeanUtils.copyProperties(transaction, i);
            transactionRecordMapper.updateTransactionRecord(i);
        }
        return result;
    }

    /**
     * 批量删除transaction
     *
     * @param tIds 需要删除的transaction主键
     * @return 结果
     */
    @Override
    public int deleteTransactionByTIds(String tIds) {
        transactionRecordMapper.deleteTransactionRecordBytIds(Convert.toStrArray(tIds));
        return transactionMapper.deleteTransactionByTIds(Convert.toStrArray(tIds));
    }

    /**
     * 删除transaction信息
     *
     * @param tId transaction主键
     * @return 结果
     */
    @Override
    public int deleteTransactionByTId(Long tId) {
        transactionRecordMapper.deleteTransactionRecordBytId(tId);
        return transactionMapper.deleteTransactionByTId(tId);
    }
}

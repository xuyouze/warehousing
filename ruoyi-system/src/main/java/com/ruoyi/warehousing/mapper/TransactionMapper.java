package com.ruoyi.warehousing.mapper;

import java.util.List;
import com.ruoyi.warehousing.domain.Transaction;

/**
 * transactionMapper接口
 * 
 * @author youze.xu
 * @date 2022-10-24
 */
public interface TransactionMapper 
{
    /**
     * 查询transaction
     * 
     * @param tId transaction主键
     * @return transaction
     */
    public Transaction selectTransactionByTId(Long tId);

    /**
     * 查询transaction列表
     * 
     * @param transaction transaction
     * @return transaction集合
     */
    public List<Transaction> selectTransactionList(Transaction transaction);

    /**
     * 新增transaction
     * 
     * @param transaction transaction
     * @return 结果
     */
    public int insertTransaction(Transaction transaction);

    /**
     * 修改transaction
     * 
     * @param transaction transaction
     * @return 结果
     */
    public int updateTransaction(Transaction transaction);

    /**
     * 删除transaction
     * 
     * @param tId transaction主键
     * @return 结果
     */
    public int deleteTransactionByTId(Long tId);

    /**
     * 批量删除transaction
     * 
     * @param tIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTransactionByTIds(String[] tIds);
}

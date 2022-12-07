package com.ruoyi.warehousing.service;

import com.ruoyi.warehousing.domain.TransactionRecord;
import com.ruoyi.warehousing.domain.TransactionRecordStatistics;

import java.util.List;
import java.util.Map;

/**
 * transaction_record_statisticsService接口
 *
 * @author ruoyi
 * @date 2022-10-25
 */
public interface ITransactionRecordStatisticsService {
    public List<TransactionRecordStatistics> selectTransactionRecordStatisticsGroupList(Map<String, Object> params);


}

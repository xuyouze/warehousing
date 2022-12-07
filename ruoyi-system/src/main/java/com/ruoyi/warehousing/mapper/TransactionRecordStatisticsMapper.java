package com.ruoyi.warehousing.mapper;


import com.ruoyi.warehousing.domain.TransactionRecordStatistics;

import java.util.List;
import java.util.Map;

/**
 * transaction_recordMapper接口
 * 
 * @author ruoyi
 * @date 2022-10-25
 */
public interface TransactionRecordStatisticsMapper
{
    public List<TransactionRecordStatistics> selectTransactionRecordStatisticsGroupList(Map<String,Object> params);

}

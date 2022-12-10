package com.ruoyi.warehousing.service.impl;


import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.warehousing.domain.Commodity;
import com.ruoyi.warehousing.domain.Manufacturer;
import com.ruoyi.warehousing.domain.TransactionRecordStatistics;
import com.ruoyi.warehousing.mapper.CommodityMapper;
import com.ruoyi.warehousing.mapper.ManufacturerMapper;
import com.ruoyi.warehousing.mapper.TransactionRecordStatisticsMapper;
import com.ruoyi.warehousing.service.ITransactionRecordStatisticsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * transaction_recordStatisticsService业务层处理
 *
 * @author youze.xu
 * @date 2022-12-02
 */
@Service
public class TransactionRecordStatisticsServiceImpl implements ITransactionRecordStatisticsService {
    @Autowired
    private TransactionRecordStatisticsMapper transactionRecordStatisticsMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private ManufacturerMapper manufacturerMapper;


    /**
     * 分组查询流转记录统计列表
     *
     * @param params
     * @return
     */
    @Override
    public List<TransactionRecordStatistics> selectTransactionRecordStatisticsGroupList(Map<String, Object> params) {
        //分组参数
        String selectParam = (String) params.get("selectParam");
        System.out.println(selectParam);
        List<String> selectParamsList = Arrays.asList(selectParam.split(","));
//
//        if (StringUtils.isNotEmpty(selectParam)) {
//            String groupby = "";
//            String groupfield = "";
//            groupby += "in_or_out,";
//            groupfield += "in_or_out,";
//
//            if (selectParam.contains("2")) {
//                groupby = groupby + "color,";
//                groupfield = groupfield + "color,";
//            }
//            if (selectParam.contains("3")) {
//                groupby = groupby + "c_id,";
//                groupfield = groupfield + "c_id,";
//            }
//            if (selectParam.contains("4")) {
//                groupby = groupby + "m_id,";
//                groupfield = groupfield + "m_id,";
//            }
//            if (groupby.endsWith(",")) {
//                groupby = groupby.substring(0, groupby.length() - 1);
//            }
//            params.put("groupby", groupby);
//            //字段用
//            groupfield = groupfield + "sum(amount) as amount, count(*) as count";
//            params.put("groupfield", groupfield);
//        }
        params.put("selectParams", selectParamsList);
        List<TransactionRecordStatistics> list = transactionRecordStatisticsMapper.selectTransactionRecordStatisticsGroupList(params);
        if (CollectionUtils.isNotEmpty(list)) {
            for (TransactionRecordStatistics transactionRecordStatistics : list) {
                //2 数据来源
                if (Objects.nonNull(transactionRecordStatistics.getcId())) {
                    Commodity commodity = commodityMapper.selectCommodityByCId(transactionRecordStatistics.getcId());
                    if (Objects.nonNull(commodity)) {
                        transactionRecordStatistics.setCommodityName(commodity.getCommodityName());
                    }
                }
                if (Objects.nonNull(transactionRecordStatistics.getmId())) {
                    Manufacturer manufacturer = manufacturerMapper.selectManufacturerByMId(transactionRecordStatistics.getmId());
                    if (Objects.nonNull(manufacturer)) {
                        transactionRecordStatistics.setManufacturerName(manufacturer.getManufacturerName());
                    }
                }
                transactionRecordStatistics.setUnit("斤");
            }
        }
        return list;
    }

}

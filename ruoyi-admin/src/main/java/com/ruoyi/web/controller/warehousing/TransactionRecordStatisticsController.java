package com.ruoyi.web.controller.warehousing;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.warehousing.domain.TransactionRecordStatistics;
import com.ruoyi.warehousing.service.ICommodityService;
import com.ruoyi.warehousing.service.IManufacturerService;
import com.ruoyi.warehousing.service.ITransactionRecordService;
import com.ruoyi.warehousing.service.ITransactionRecordStatisticsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: xu_xu
 * @date: 2022/12/4 15:31
 */

@Controller
@RequestMapping("/warehousing/transaction_record_statistics")
public class TransactionRecordStatisticsController extends BaseController {

    private final String prefix = "warehousing/transaction_record_statistics";

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private ITransactionRecordStatisticsService transactionRecordStatisticsService;

    @RequiresPermissions("warehousing:transaction_record_statistics:view")
    @GetMapping()
    public String transaction_record(ModelMap mmap)
    {
        mmap.put("manufacturerList", manufacturerService.selectManufacturerAll());
        mmap.put("commodityList", commodityService.selectCommodityAll());
        return prefix + "/statistics";
    }

    /**
     * 分组查询流转记录统计列表
     */
    @RequiresPermissions("warehousing:transaction_record_statistics::list")
    @PostMapping("/getTransactionRecordStatisticsDataGroup")
    @ResponseBody
    public TableDataInfo getTransactionRecordStatisticsGroup(@RequestParam Map<String,Object> params)
    {
        startPage();
        List<TransactionRecordStatistics> list =
                transactionRecordStatisticsService.selectTransactionRecordStatisticsGroupList(params);
        return getDataTable(list);
    }
}

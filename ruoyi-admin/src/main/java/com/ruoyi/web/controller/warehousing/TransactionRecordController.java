package com.ruoyi.web.controller.warehousing;

import java.util.List;

import com.ruoyi.warehousing.service.ICommodityService;
import com.ruoyi.warehousing.service.IManufacturerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.warehousing.domain.TransactionRecord;
import com.ruoyi.warehousing.service.ITransactionRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * transaction_recordController
 * 
 * @author ruoyi
 * @date 2022-10-25
 */
@Controller
@RequestMapping("/warehousing/transaction_record")
public class TransactionRecordController extends BaseController
{
    private String prefix = "warehousing/transaction_record";

    @Autowired
    private ITransactionRecordService transactionRecordService;

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private ICommodityService commodityService;

    @RequiresPermissions("warehousing:transaction_record:view")
    @GetMapping()
    public String transaction_record(ModelMap mmap)
    {
        mmap.put("manufacturerList", manufacturerService.selectManufacturerAll());
        mmap.put("commodityList", commodityService.selectCommodityAll());
        return prefix + "/transaction_record";
    }

    /**
     * 查询transaction_record列表
     */
    @RequiresPermissions("warehousing:transaction_record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TransactionRecord transactionRecord)
    {
        startPage();
        List<TransactionRecord> list = transactionRecordService.selectTransactionRecordList(transactionRecord);
        return getDataTable(list);
    }

    /**
     * 导出transaction_record列表
     */
    @RequiresPermissions("warehousing:transaction_record:export")
    @Log(title = "transaction_record", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TransactionRecord transactionRecord)
    {
        List<TransactionRecord> list = transactionRecordService.selectTransactionRecordList(transactionRecord);
        ExcelUtil<TransactionRecord> util = new ExcelUtil<TransactionRecord>(TransactionRecord.class);
        return util.exportExcel(list, "transaction_record数据");
    }

    /**
     * 新增transaction_record
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存transaction_record
     */
    @RequiresPermissions("warehousing:transaction_record:add")
    @Log(title = "transaction_record", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TransactionRecord transactionRecord)
    {
        return toAjax(transactionRecordService.insertTransactionRecord(transactionRecord));
    }

    /**
     * 修改transaction_record
     */
    @RequiresPermissions("warehousing:transaction_record:edit")
    @GetMapping("/edit/{trId}")
    public String edit(@PathVariable("trId") Long trId, ModelMap mmap)
    {
        TransactionRecord transactionRecord = transactionRecordService.selectTransactionRecordByTrId(trId);
        mmap.put("commodityList", commodityService.selectCommodityAll());
        mmap.put("transactionRecord", transactionRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存transaction_record
     */
    @RequiresPermissions("warehousing:transaction_record:edit")
    @Log(title = "transaction_record", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TransactionRecord transactionRecord)
    {
        return toAjax(transactionRecordService.updateTransactionRecord(transactionRecord));
    }

    /**
     * 删除transaction_record
     */
    @RequiresPermissions("warehousing:transaction_record:remove")
    @Log(title = "transaction_record", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(transactionRecordService.deleteTransactionRecordByTrIds(ids));
    }
}

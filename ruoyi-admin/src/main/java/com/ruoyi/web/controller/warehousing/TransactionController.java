package com.ruoyi.web.controller.warehousing;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.warehousing.service.ICommodityService;
import com.ruoyi.warehousing.service.IManufacturerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.warehousing.domain.Transaction;
import com.ruoyi.warehousing.service.ITransactionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * transactionController
 *
 * @author youze.xu
 * @date 2022-10-24
 */
@Controller
@RequestMapping("/warehousing/transaction")
public class TransactionController extends BaseController {
    private String prefix = "warehousing/transaction";

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private ICommodityService commodityService;

    @RequiresPermissions("warehousing:transaction:view")
    @GetMapping()
    public String transaction(ModelMap mmap) {
        mmap.put("manufacturerList", manufacturerService.selectManufacturerAll());
        return prefix + "/transaction";
    }

    /**
     * 查询transaction列表
     */
    @RequiresPermissions("warehousing:transaction:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Transaction transaction) {
        startPage();
        List<Transaction> list = transactionService.selectTransactionList(transaction);

        return getDataTable(list);
    }

    /**
     * 导出transaction列表
     */
    @RequiresPermissions("warehousing:transaction:export")
    @Log(title = "transaction", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Transaction transaction) {
        List<Transaction> list = transactionService.selectTransactionList(transaction);
        ExcelUtil<Transaction> util = new ExcelUtil<Transaction>(Transaction.class);
        return util.exportExcel(list, "transaction数据");
    }

    /**
     * 新增transaction
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("commodityList", commodityService.selectCommodityAll());
        mmap.put("manufacturerList", manufacturerService.selectManufacturerAll());
        mmap.put("today_date", DateUtils.getDate());
        return prefix + "/add";
    }

    /**
     * 新增保存transaction
     */
    @RequiresPermissions("warehousing:transaction:add")
    @Log(title = "transaction", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody Transaction transaction) {
        transaction.setCreateBy(getLoginName());
        return toAjax(transactionService.insertTransaction(transaction));
    }

    /**
     * 修改transaction
     */
    @RequiresPermissions("warehousing:transaction:edit")
    @GetMapping("/edit/{tId}")
    public String edit(@PathVariable("tId") Long tId, ModelMap mmap) {
        Transaction transaction = transactionService.selectTransactionByTId(tId);
        mmap.put("transaction", transaction);
        mmap.put("manufacturerList", manufacturerService.selectManufacturerAll());
//        mmap.put("manufacturer", manufacturerService.selectManufacturerByMId(transaction.getmId()));
        return prefix + "/edit";
    }

    /**
     * 修改保存transaction
     */
    @RequiresPermissions("warehousing:transaction:edit")
    @Log(title = "transaction", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Transaction transaction) {
        return toAjax(transactionService.updateTransaction(transaction));
    }

    /**
     * 删除transaction
     */
    @RequiresPermissions("warehousing:transaction:remove")
    @Log(title = "transaction", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(transactionService.deleteTransactionByTIds(ids));
    }
}

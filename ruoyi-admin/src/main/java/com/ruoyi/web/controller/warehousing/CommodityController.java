package com.ruoyi.web.controller.warehousing;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.warehousing.domain.Commodity;
import com.ruoyi.warehousing.service.ICommodityService;
import com.ruoyi.warehousing.service.ITransactionRecordService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * commodityController
 * 
 * @author youze.xu
 * @date 2022-10-19
 */
@Controller
@RequestMapping("/warehousing/commodity")
public class CommodityController extends BaseController
{
    private String prefix = "warehousing/commodity";

    @Autowired
    private ICommodityService commodityService;

    @Autowired
    private ITransactionRecordService iTransactionRecordService;

    @RequiresPermissions("warehousing:commodity:view")
    @GetMapping()
    public String commodity()
    {
        return prefix + "/commodity";
    }

    /**
     * 查询commodity列表
     */
    @RequiresPermissions("warehousing:commodity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Commodity commodity)
    {
        startPage();
        List<Commodity> list = commodityService.selectCommodityList(commodity);
        return getDataTable(list);
    }

    /**
     * 导出commodity列表
     */
    @RequiresPermissions("warehousing:commodity:export")
    @Log(title = "commodity", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Commodity commodity)
    {
        List<Commodity> list = commodityService.selectCommodityList(commodity);
        ExcelUtil<Commodity> util = new ExcelUtil<Commodity>(Commodity.class);
        return util.exportExcel(list, "commodity数据");
    }

    /**
     * 新增commodity
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存commodity
     */
    @RequiresPermissions("warehousing:commodity:add")
    @Log(title = "commodity", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Commodity commodity)
    {
        commodity.setCreateBy(getLoginName());
        return toAjax(commodityService.insertCommodity(commodity));
    }

    /**
     * 修改commodity
     */
    @RequiresPermissions("warehousing:commodity:edit")
    @GetMapping("/edit/{cId}")
    public String edit(@PathVariable("cId") Long cId, ModelMap mmap)
    {
        Commodity commodity = commodityService.selectCommodityByCId(cId);
        mmap.put("commodity", commodity);
        return prefix + "/edit";
    }

    /**
     * 修改保存commodity
     */
    @RequiresPermissions("warehousing:commodity:edit")
    @Log(title = "commodity", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Commodity commodity)
    {
        commodity.setUpdateBy(getLoginName());
        return toAjax(commodityService.updateCommodity(commodity));
    }

    /**
     * 删除commodity
     */
    @RequiresPermissions("warehousing:commodity:remove")
    @Log(title = "commodity", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        if (iTransactionRecordService.selectTransactionRecordBycId(ids) == null){
            return toAjax(commodityService.deleteCommodityByCIds(ids));
        }
        return error("请删除对应的商品出入记录");
    }
}

package com.ruoyi.web.controller.warehousing;

import java.util.List;
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
import com.ruoyi.warehousing.domain.Manufacturer;
import com.ruoyi.warehousing.service.IManufacturerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * manufacturerController
 * 
 * @author youze.xu
 * @date 2022-10-23
 */
@Controller
@RequestMapping("/warehousing/manufacturer")
public class ManufacturerController extends BaseController
{
    private String prefix = "warehousing/manufacturer";

    @Autowired
    private IManufacturerService manufacturerService;

    @RequiresPermissions("warehousing:manufacturer:view")
    @GetMapping()
    public String manufacturer()
    {
        return prefix + "/manufacturer";
    }

    /**
     * 查询manufacturer列表
     */
    @RequiresPermissions("warehousing:manufacturer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Manufacturer manufacturer)
    {
        startPage();
        List<Manufacturer> list = manufacturerService.selectManufacturerList(manufacturer);
        return getDataTable(list);
    }

    /**
     * 导出manufacturer列表
     */
    @RequiresPermissions("warehousing:manufacturer:export")
    @Log(title = "manufacturer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Manufacturer manufacturer)
    {
        List<Manufacturer> list = manufacturerService.selectManufacturerList(manufacturer);
        ExcelUtil<Manufacturer> util = new ExcelUtil<Manufacturer>(Manufacturer.class);
        return util.exportExcel(list, "manufacturer数据");
    }

    /**
     * 新增manufacturer
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存manufacturer
     */
    @RequiresPermissions("warehousing:manufacturer:add")
    @Log(title = "manufacturer", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Manufacturer manufacturer)
    {
        manufacturer.setCreateBy(getLoginName());

        return toAjax(manufacturerService.insertManufacturer(manufacturer));
    }

    /**
     * 修改manufacturer
     */
    @RequiresPermissions("warehousing:manufacturer:edit")
    @GetMapping("/edit/{mId}")
    public String edit(@PathVariable("mId") Long mId, ModelMap mmap)
    {
        Manufacturer manufacturer = manufacturerService.selectManufacturerByMId(mId);
        mmap.put("manufacturer", manufacturer);
        return prefix + "/edit";
    }

    /**
     * 修改保存manufacturer
     */
    @RequiresPermissions("warehousing:manufacturer:edit")
    @Log(title = "manufacturer", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Manufacturer manufacturer)
    {
        manufacturer.setUpdateBy(getLoginName());
        return toAjax(manufacturerService.updateManufacturer(manufacturer));
    }

    /**
     * 删除manufacturer
     */
    @RequiresPermissions("warehousing:manufacturer:remove")
    @Log(title = "manufacturer", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(manufacturerService.deleteManufacturerByMIds(ids));
    }
}

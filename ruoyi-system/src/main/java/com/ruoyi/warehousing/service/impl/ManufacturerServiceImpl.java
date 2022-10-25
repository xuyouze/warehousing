package com.ruoyi.warehousing.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.warehousing.mapper.ManufacturerMapper;
import com.ruoyi.warehousing.domain.Manufacturer;
import com.ruoyi.warehousing.service.IManufacturerService;
import com.ruoyi.common.core.text.Convert;

/**
 * manufacturerService业务层处理
 * 
 * @author youze.xu
 * @date 2022-10-23
 */
@Service
public class ManufacturerServiceImpl implements IManufacturerService 
{
    @Autowired
    private ManufacturerMapper manufacturerMapper;

    /**
     * 查询manufacturer
     * 
     * @param mId manufacturer主键
     * @return manufacturer
     */
    @Override
    public Manufacturer selectManufacturerByMId(Long mId)
    {
        return manufacturerMapper.selectManufacturerByMId(mId);
    }

    /**
     * 查询manufacturer列表
     * 
     * @param manufacturer manufacturer
     * @return manufacturer
     */
    @Override
    public List<Manufacturer> selectManufacturerList(Manufacturer manufacturer)
    {
        return manufacturerMapper.selectManufacturerList(manufacturer);
    }

    /**
     * 新增manufacturer
     * 
     * @param manufacturer manufacturer
     * @return 结果
     */
    @Override
    public int insertManufacturer(Manufacturer manufacturer)
    {
        manufacturer.setCreateTime(DateUtils.getNowDate());
        return manufacturerMapper.insertManufacturer(manufacturer);
    }

    /**
     * 修改manufacturer
     * 
     * @param manufacturer manufacturer
     * @return 结果
     */
    @Override
    public int updateManufacturer(Manufacturer manufacturer)
    {
        manufacturer.setUpdateTime(DateUtils.getNowDate());
        return manufacturerMapper.updateManufacturer(manufacturer);
    }

    /**
     * 批量删除manufacturer
     * 
     * @param mIds 需要删除的manufacturer主键
     * @return 结果
     */
    @Override
    public int deleteManufacturerByMIds(String mIds)
    {
        return manufacturerMapper.deleteManufacturerByMIds(Convert.toStrArray(mIds));
    }

    /**
     * 删除manufacturer信息
     * 
     * @param mId manufacturer主键
     * @return 结果
     */
    @Override
    public int deleteManufacturerByMId(Long mId)
    {
        return manufacturerMapper.deleteManufacturerByMId(mId);
    }
}

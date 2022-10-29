package com.ruoyi.warehousing.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.warehousing.domain.Commodity;
import com.ruoyi.warehousing.mapper.CommodityMapper;
import com.ruoyi.warehousing.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * commodityService业务层处理
 * 
 * @author youze.xu
 * @date 2022-10-19
 */
@Service
public class CommodityServiceImpl implements ICommodityService
{
    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 查询commodity
     * 
     * @param cId commodity主键
     * @return commodity
     */
    @Override
    public Commodity selectCommodityByCId(Long cId)
    {
        return commodityMapper.selectCommodityByCId(cId);
    }

    /**
     * 查询commodity列表
     * 
     * @param commodity commodity
     * @return commodity
     */
    @Override
    public List<Commodity> selectCommodityList(Commodity commodity)
    {
        return commodityMapper.selectCommodityList(commodity);
    }

    /**
     * 新增commodity
     * 
     * @param commodity commodity
     * @return 结果
     */
    @Override
    public int insertCommodity(Commodity commodity)
    {
        commodity.setCreateTime(DateUtils.getNowDate());
        return commodityMapper.insertCommodity(commodity);
    }

    /**
     * 修改commodity
     * 
     * @param commodity commodity
     * @return 结果
     */
    @Override
    public int updateCommodity(Commodity commodity)
    {
        commodity.setUpdateTime(DateUtils.getNowDate());
        return commodityMapper.updateCommodity(commodity);
    }

    /**
     * 批量删除commodity
     * 
     * @param cIds 需要删除的commodity主键
     * @return 结果
     */
    @Override
    public int deleteCommodityByCIds(String cIds)
    {
        return commodityMapper.deleteCommodityByCIds(Convert.toStrArray(cIds));
    }

    /**
     * 删除commodity信息
     * 
     * @param cId commodity主键
     * @return 结果
     */
    @Override
    public int deleteCommodityByCId(Long cId)
    {
        return commodityMapper.deleteCommodityByCId(cId);
    }

    @Override
    public List<Commodity> selectCommodityAll() {
        return commodityMapper.selectCommodityAll();
    }
}

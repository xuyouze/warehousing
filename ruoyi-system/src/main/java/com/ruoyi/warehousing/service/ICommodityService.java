package com.ruoyi.warehousing.service;

import com.ruoyi.warehousing.domain.Commodity;
import com.ruoyi.warehousing.domain.Manufacturer;

import java.util.List;

/**
 * commodityService接口
 * 
 * @author youze.xu
 * @date 2022-10-19
 */
public interface ICommodityService 
{
    /**
     * 查询commodity
     * 
     * @param cId commodity主键
     * @return commodity
     */
    public Commodity selectCommodityByCId(Long cId);

    /**
     * 查询commodity列表
     * 
     * @param commodity commodity
     * @return commodity集合
     */
    public List<Commodity> selectCommodityList(Commodity commodity);

    /**
     * 新增commodity
     * 
     * @param commodity commodity
     * @return 结果
     */
    public int insertCommodity(Commodity commodity);

    /**
     * 修改commodity
     * 
     * @param commodity commodity
     * @return 结果
     */
    public int updateCommodity(Commodity commodity);

    /**
     * 批量删除commodity
     * 
     * @param cIds 需要删除的commodity主键集合
     * @return 结果
     */
    public int deleteCommodityByCIds(String cIds);

    /**
     * 删除commodity信息
     * 
     * @param cId commodity主键
     * @return 结果
     */
    public int deleteCommodityByCId(Long cId);

    public List<Commodity> selectCommodityAll();

}

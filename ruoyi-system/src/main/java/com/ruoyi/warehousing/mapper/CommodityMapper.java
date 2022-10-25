package com.ruoyi.warehousing.mapper;

import com.ruoyi.warehousing.domain.Commodity;

import java.util.List;

/**
 * commodityMapper接口
 * 
 * @author youze.xu
 * @date 2022-10-19
 */
public interface CommodityMapper 
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
     * 删除commodity
     * 
     * @param cId commodity主键
     * @return 结果
     */
    public int deleteCommodityByCId(Long cId);

    /**
     * 批量删除commodity
     * 
     * @param cIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommodityByCIds(String[] cIds);
}

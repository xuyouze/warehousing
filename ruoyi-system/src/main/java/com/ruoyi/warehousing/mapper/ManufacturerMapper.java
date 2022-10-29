package com.ruoyi.warehousing.mapper;

import java.util.List;

import com.ruoyi.warehousing.domain.Manufacturer;

/**
 * manufacturerMapper接口
 *
 * @author youze.xu
 * @date 2022-10-23
 */
public interface ManufacturerMapper {
    /**
     * 查询manufacturer
     *
     * @param mId manufacturer主键
     * @return manufacturer
     */
    public Manufacturer selectManufacturerByMId(Long mId);

    /**
     * 查询manufacturer列表
     *
     * @param manufacturer manufacturer
     * @return manufacturer集合
     */
    public List<Manufacturer> selectManufacturerList(Manufacturer manufacturer);

    /**
     * 新增manufacturer
     *
     * @param manufacturer manufacturer
     * @return 结果
     */
    public int insertManufacturer(Manufacturer manufacturer);

    /**
     * 修改manufacturer
     *
     * @param manufacturer manufacturer
     * @return 结果
     */
    public int updateManufacturer(Manufacturer manufacturer);

    /**
     * 删除manufacturer
     *
     * @param mId manufacturer主键
     * @return 结果
     */
    public int deleteManufacturerByMId(Long mId);

    /**
     * 批量删除manufacturer
     *
     * @param mIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteManufacturerByMIds(String[] mIds);

    public List<Manufacturer> selectManufacturerAll();

}

package com.kailaisi.eshopproductservice.mapper

import com.kailaisi.eshopproductservice.model.Brand
import org.apache.ibatis.annotations.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:24
 */
@Mapper
interface BrandMapper {
    @Insert("Insert into brand(name,description) values(#{name},#{description})")
    fun addBrand(brand: Brand)

    @Delete("delete from brand where id=#{id}")
    fun delete(id: Long)

    @Update("update brand set name=#{name},description=#{description} where id=#{id}")
    fun update(brand: Brand)

    @Select("select * from brand where id=#{id}")
    fun findById(id: Long): Brand
}
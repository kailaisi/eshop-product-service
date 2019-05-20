package com.kailaisi.eshopproductservice.mapper

import com.kailaisi.eshopproductservice.model.Product
import org.apache.ibatis.annotations.*

/**
 *描述：获取产品信息
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:24
 */
@Mapper
interface ProductMapper {
    @Insert("Insert into product(name,category_id,brand_id) values(#{name},#{categoryId},#{brandId})")
    fun addProduct(product: Product)

    @Delete("delete from product where id=#{id}")
    fun delete(id: Long)

    @Update("update product set name=#{name},category_id=#{categoryId},brand_id=#{brandId} where id=#{id}")
    fun update(product: Product)

    @Select("select * from category where id=#{id}")
    @Results(
            Result(column = "category_id", property = "categoryId"),
            Result(column = "brand_id", property = "brandId")
    )
    fun findById(id: Long): Product
}
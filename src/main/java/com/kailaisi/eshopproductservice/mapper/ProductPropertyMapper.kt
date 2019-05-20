package com.kailaisi.eshopproductservice.mapper

import com.kailaisi.eshopproductservice.model.ProductProperty
import org.apache.ibatis.annotations.*

/**
 *描述：获取产品属性信息
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:24
 */
@Mapper
interface ProductPropertyMapper {
    @Insert("Insert into product_property(name,value,product_id) values(#{name},#{value},#{productId})")
    fun add(product: ProductProperty)

    @Delete("delete from product_property where id=#{id}")
    fun delete(id: Long)

    @Update("update product_property set name=#{name},product_id=#{productId},value=#{value} where id=#{id}")
    fun update(product: ProductProperty)

    @Select("select * from product_property where id=#{id}")
    @Results(
            Result(column = "product_id", property = "productId")
    )
    fun findById(id: Long): ProductProperty
}
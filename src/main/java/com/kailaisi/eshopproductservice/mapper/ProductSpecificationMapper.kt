package com.kailaisi.eshopproductservice.mapper

import com.kailaisi.eshopproductservice.model.ProductSpecification
import org.apache.ibatis.annotations.*

/**
 *描述：获取产品属性信息
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:24
 */
@Mapper
interface ProductSpecificationMapper {
    @Insert("Insert into product_specification(name,value,product_id) values(#{name},#{value},#{productId})")
    fun add(productSpecification: ProductSpecification)

    @Delete("delete from product_specification where id=#{id}")
    fun delete(id: Long)

    @Update("update product_specification set name=#{name},product_id=#{productId},value=#{value} where id=#{id}")
    fun update(productSpecification: ProductSpecification)

    @Select("select * from product_specification where id=#{id}")
    @Results(
            Result(column = "product_id", property = "productId")
    )
    fun findById(id: Long): ProductSpecification
    @Select("select * from product_specification where product_id=#{id}")
    @Results(
            Result(column = "product_id", property = "productId")
    )
    fun findByProductId(id: Long): List<ProductSpecification>
}
package com.kailaisi.eshopproductservice.mapper

import com.kailaisi.eshopproductservice.model.ProductDesc
import org.apache.ibatis.annotations.*

/**
 *描述：获取产品信息
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:24
 */
@Mapper
interface ProductDescMapper {
    @Insert("Insert into product_desc(content,product_id) values(#{content},#{productId})")
    fun add(productDesc: ProductDesc)

    @Delete("delete from product_desc where id=#{id}")
    fun delete(id: Long)

    @Update("update product_desc set content=#{content},product_id=#{productId} where id=#{id}")
    fun update(productDesc: ProductDesc)

    @Select("select * from product_desc where id=#{id}")
    @Results(
            Result(column = "product_id", property = "productId")
    )
    fun findById(id: Long): ProductDesc

    @Select("select * from product_desc where product_id=#{id}")
    @Results(
            Result(column = "product_id", property = "productId")
    )
    fun findByProductId(id: Long): List<ProductDesc>
}
package com.kailaisi.eshopproductservice.service

import com.kailaisi.eshopproductservice.model.ProductProperty


/**
 *描述：产品属性
 *<p/>作者：wu
 *<br/>创建时间：2019/5/15 17:06
 */
interface ProductPropertyService {
    fun add(productProperty: ProductProperty)
    fun delete(id: Long)
    fun update(productProperty: ProductProperty)
    fun findById(id: Long): ProductProperty
    fun findByProductId(id: Long): List<ProductProperty>
}
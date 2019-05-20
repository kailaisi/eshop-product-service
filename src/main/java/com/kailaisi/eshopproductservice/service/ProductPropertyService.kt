package com.kailaisi.eshopproductservice.service

import com.kailaisi.eshopproductservice.model.ProductProperty


/**
 *描述：产品属性
 *<p/>作者：wu
 *<br/>创建时间：2019/5/15 17:06
 */
interface ProductPropertyService {
    fun add(productproperty: ProductProperty)
    fun delete(id: Long)
    fun update(productproperty: ProductProperty)
    fun findById(id: Long): ProductProperty
}
package com.kailaisi.eshopproductdescservice.service

import com.kailaisi.eshopproductservice.model.ProductDesc


/**
 *描述：产品描述
 *<p/>作者：wu
 *<br/>创建时间：2019/5/15 17:06
 */
interface ProductDescService {
    fun add(productDesc: ProductDesc)
    fun delete(id: Long)
    fun update(productDesc: ProductDesc)
    fun findById(id: Long): ProductDesc
}
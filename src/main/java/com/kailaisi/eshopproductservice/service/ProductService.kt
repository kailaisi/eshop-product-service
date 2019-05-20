package com.kailaisi.eshopproductservice.service

import com.kailaisi.eshopproductservice.model.Product


/**
 *描述：品牌
 *<p/>作者：wu
 *<br/>创建时间：2019/5/15 17:06
 */
interface ProductService {
    fun add(product: Product)
    fun delete(id: Long)
    fun update(product: Product)
    fun findById(id: Long): Product
}
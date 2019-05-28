package com.kailaisi.eshopproductservice.service

import com.kailaisi.eshopproductservice.model.ProductSpecification


/**
 *描述：商品规格
 *<p/>作者：wu
 *<br/>创建时间：2019/5/15 17:06
 */
interface ProductSpecificationService {
    fun add(productSpecification: ProductSpecification)
    fun delete(id: Long)
    fun update(productSpecification: ProductSpecification)
    fun findById(id: Long): ProductSpecification
    fun findByProductId(id: Long): List<ProductSpecification>
}
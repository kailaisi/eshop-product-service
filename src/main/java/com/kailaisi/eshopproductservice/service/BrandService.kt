package com.kailaisi.eshopproductservice.service

import com.kailaisi.eshopproductservice.model.Brand
import org.springframework.stereotype.Service


/**
 *描述：品牌
 *<p/>作者：wu
 *<br/>创建时间：2019/5/15 17:06
 */
interface BrandService {
    fun add(brand: Brand)
    fun delete(id: Long)
    fun update(brand: Brand)
    fun findById(id: Long): Brand
    fun findByIds(id: String): List<Brand>
}
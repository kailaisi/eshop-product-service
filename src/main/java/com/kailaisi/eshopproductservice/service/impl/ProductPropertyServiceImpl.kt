package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.ProductPropertyMapper
import com.kailaisi.eshopproductservice.model.ProductProperty
import com.kailaisi.eshopproductservice.service.ProductPropertyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductPropertyServiceImpl : ProductPropertyService {
    @Autowired
    lateinit var mapper: ProductPropertyMapper

    override fun add(productproperty: ProductProperty) = mapper.add(productproperty)

    override fun delete(id: Long) = mapper.delete(id)

    override fun update(productproperty: ProductProperty) = mapper.update(productproperty)

    override fun findById(id: Long): ProductProperty = mapper.findById(id)
}
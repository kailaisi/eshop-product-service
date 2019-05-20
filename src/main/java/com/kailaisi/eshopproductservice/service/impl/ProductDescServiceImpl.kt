package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductdescservice.service.ProductDescService
import com.kailaisi.eshopproductservice.mapper.ProductDescMapper
import com.kailaisi.eshopproductservice.model.ProductDesc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductDescServiceImpl : ProductDescService {
    @Autowired
    lateinit var mapper: ProductDescMapper

    override fun add(productDesc: ProductDesc) = mapper.add(productDesc)

    override fun delete(id: Long) = mapper.delete(id)

    override fun update(productDesc: ProductDesc) = mapper.update(productDesc)

    override fun findById(id: Long): ProductDesc = mapper.findById(id)
}
package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.ProductSpecificationMapper
import com.kailaisi.eshopproductservice.model.ProductSpecification
import com.kailaisi.eshopproductservice.service.ProductSpecificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductSpecificationServiceImpl : ProductSpecificationService {
    @Autowired
    lateinit var mapper: ProductSpecificationMapper

    override fun add(productSpecification: ProductSpecification) = mapper.add(productSpecification)

    override fun delete(id: Long) = mapper.delete(id)

    override fun update(productSpecification: ProductSpecification) = mapper.update(productSpecification)

    override fun findById(id: Long): ProductSpecification = mapper.findById(id)
}
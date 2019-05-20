package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.ProductMapper
import com.kailaisi.eshopproductservice.model.Product
import com.kailaisi.eshopproductservice.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductServiceImpl : ProductService {
    @Autowired
    lateinit var productMapper: ProductMapper

    override fun add(product: Product) = productMapper.addProduct(product)

    override fun delete(id: Long) = productMapper.delete(id)

    override fun update(product: Product) = productMapper.update(product)

    override fun findById(id: Long): Product = productMapper.findById(id)
}
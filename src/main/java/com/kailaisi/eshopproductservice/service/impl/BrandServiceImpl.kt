package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.BrandMapper
import com.kailaisi.eshopproductservice.model.Brand
import com.kailaisi.eshopproductservice.service.BrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class BrandServiceImpl : BrandService {
    @Autowired
    lateinit var brandMapper: BrandMapper

    override fun add(brand: Brand) = brandMapper.addBrand(brand)

    override fun delete(id: Long) = brandMapper.delete(id)

    override fun update(brand: Brand) = brandMapper.update(brand)

    override fun findById(id: Long): Brand = brandMapper.findById(id)
}
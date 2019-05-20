package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.CategoryMapper
import com.kailaisi.eshopproductservice.model.Category
import com.kailaisi.eshopproductservice.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class CategoryServiceImpl : CategoryService {
    @Autowired
    lateinit var categoryMapper: CategoryMapper

    override fun add(category: Category) {
        categoryMapper.addCategory(category)
    }

    override fun delete(id: Long) {
        categoryMapper.delete(id)
    }

    override fun update(category: Category) {
        categoryMapper.update(category)
    }

    override fun findById(id: Long): Category = categoryMapper.findById(id)
}
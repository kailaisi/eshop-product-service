package com.kailaisi.eshopproductservice.service

import com.kailaisi.eshopproductservice.model.Category
import org.springframework.stereotype.Service


/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/15 17:06
 */
interface CategoryService {
    fun add(category: Category)
    fun delete(id: Long)
    fun update(category: Category)
    fun findById(id: Long): Category
}
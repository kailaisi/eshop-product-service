package com.kailaisi.eshopproductservice.control

import com.kailaisi.eshopproductservice.model.Category
import com.kailaisi.eshopproductservice.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:50
 */
@Controller
@RequestMapping("/category")
class CategoryControl {
    @Autowired
    lateinit var categoryService: CategoryService

    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody category: Category): String {
        categoryService.add(category)
        return "success"
    }

    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun update(@RequestBody category: Category): String {
        categoryService.update(category)
        return "success"
    }

    @RequestMapping("/delete", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun delete(id: Long): String {
        categoryService.delete(id)
        return "success"
    }

    @RequestMapping("/findById")
    @ResponseBody
    fun findById(id: Long): Category {
        return categoryService.findById(id)
    }
}
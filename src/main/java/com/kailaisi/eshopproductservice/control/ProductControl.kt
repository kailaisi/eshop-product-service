package com.kailaisi.eshopproductservice.control

import com.kailaisi.eshopproductservice.model.Product
import com.kailaisi.eshopproductservice.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:50
 */
@Controller
@RequestMapping("/product")
class ProductControl {
    @Autowired
    lateinit var productService: ProductService

    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody product: Product): String {
        productService.add(product)
        return "success"
    }

    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun update(@RequestBody product: Product): String {
        productService.update(product)
        return "success"
    }

    @RequestMapping("/delete", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun delete(id: Long): String {
        productService.delete(id)
        return "success"
    }

    @RequestMapping("/findById")
    @ResponseBody
    fun findById(id: Long): Product {
        return productService.findById(id)
    }
}
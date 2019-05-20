package com.kailaisi.eshopproductservice.control

import com.kailaisi.eshopproductservice.model.ProductProperty
import com.kailaisi.eshopproductservice.service.ProductPropertyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:50
 */
@Controller
@RequestMapping("/product-property")
class ProductPropertyControl {
    @Autowired
    lateinit var productPropertyService: ProductPropertyService

    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody productproperty: ProductProperty): String {
        productPropertyService.add(productproperty)
        return "success"
    }

    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun update(@RequestBody productproperty: ProductProperty): String {
        productPropertyService.update(productproperty)
        return "success"
    }

    @RequestMapping("/delete", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun delete(id: Long): String {
        productPropertyService.delete(id)
        return "success"
    }

    @RequestMapping("/findById")
    @ResponseBody
    fun findById(id: Long): ProductProperty {
        return productPropertyService.findById(id)
    }
}
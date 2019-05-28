package com.kailaisi.eshopproductservice.control

import com.kailaisi.eshopproductservice.model.ProductProperty
import com.kailaisi.eshopproductservice.model.ProductSpecification
import com.kailaisi.eshopproductservice.service.ProductSpecificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 *描述：商品规格
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:50
 */
@Controller
@RequestMapping("/product-specification")
class ProductSpecificationControl {
    @Autowired
    lateinit var mService: ProductSpecificationService

    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody productSpecification: ProductSpecification): String {
        mService.add(productSpecification)
        return "success"
    }

    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun update(@RequestBody productSpecification: ProductSpecification): String {
        mService.update(productSpecification)
        return "success"
    }

    @RequestMapping("/delete", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun delete(id: Long): String {
        mService.delete(id)
        return "success"
    }

    @RequestMapping("/findById")
    @ResponseBody
    fun findById(id: Long): ProductSpecification {
        return mService.findById(id)
    }

    @RequestMapping("/findByProductId")
    @ResponseBody
    fun findByProductId(id: Long): List<ProductSpecification> {
        return mService.findByProductId(id)
    }
}
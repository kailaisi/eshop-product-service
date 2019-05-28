package com.kailaisi.eshopproductservice.control

import com.kailaisi.eshopproductdescservice.service.ProductDescService
import com.kailaisi.eshopproductservice.model.ProductDesc
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
@RequestMapping("/product-desc")
class ProductDescControl {
    @Autowired
    lateinit var mService: ProductDescService

    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody productDesc: ProductDesc): String {
        mService.add(productDesc)
        return "success"
    }

    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun update(@RequestBody productDesc: ProductDesc): String {
        mService.update(productDesc)
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
    fun findById(id: Long): ProductDesc {
        return mService.findById(id)
    }

    @RequestMapping("/findByProductId")
    @ResponseBody
    fun findByProductId(id: Long): List<ProductDesc> {
        return mService.findByProductId(id)
    }
}
package com.kailaisi.eshopproductservice.control

import com.kailaisi.eshopproductservice.model.Brand
import com.kailaisi.eshopproductservice.service.BrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:50
 */
@Controller
@RequestMapping("/brand")
class BrandControl {
    @Autowired
    lateinit var brandService: BrandService

    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody brand: Brand): String {
        brandService.add(brand)
        return "success"
    }

    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun update(@RequestBody brand: Brand): String {
        brandService.update(brand)
        println("接收到请求$brand")
        return "success"
    }

    @RequestMapping("/delete", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun delete(id: Long): String {
        brandService.delete(id)
        return "success"
    }

    @RequestMapping("/findById")
    @ResponseBody
    fun findById(id: Long): Brand {
        return brandService.findById(id)
    }

    @RequestMapping("/findByIds")
    @ResponseBody
    fun findByIds(id: Long): Brand {
        return brandService.findById(id)
    }
}
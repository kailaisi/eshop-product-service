package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.BrandMapper
import com.kailaisi.eshopproductservice.model.Brand
import com.kailaisi.eshopproductservice.rabbitmq.DataChange
import com.kailaisi.eshopproductservice.rabbitmq.RabbitMQSender
import com.kailaisi.eshopproductservice.rabbitmq.RabbitQueue
import com.kailaisi.eshopproductservice.service.BrandService
import com.kailaisi.eshopproductservice.util.FastJsonUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：品牌
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class BrandServiceImpl : BrandService {
    @Autowired
    lateinit var brandMapper: BrandMapper

    @Autowired
    lateinit var rabbitMQSender: RabbitMQSender

    override fun add(brand: Brand) {
        brandMapper.addBrand(brand)
        val queueInfo = DataChange("add", "brand", brand.id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun delete(id: Long) {
        brandMapper.delete(id)
        val queueInfo = DataChange("delete", "brand", id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun update(brand: Brand) {
        brandMapper.update(brand)
        val queueInfo = DataChange("update", "brand", brand.id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun findById(id: Long): Brand = brandMapper.findById(id)
}
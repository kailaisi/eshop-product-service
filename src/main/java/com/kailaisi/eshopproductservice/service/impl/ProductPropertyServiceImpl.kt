package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.ProductPropertyMapper
import com.kailaisi.eshopproductservice.model.ProductProperty
import com.kailaisi.eshopproductservice.rabbitmq.DataChange
import com.kailaisi.eshopproductservice.rabbitmq.RabbitMQSender
import com.kailaisi.eshopproductservice.rabbitmq.RabbitQueue
import com.kailaisi.eshopproductservice.service.ProductPropertyService
import com.kailaisi.eshopproductservice.util.FastJsonUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductPropertyServiceImpl : ProductPropertyService {
    @Autowired
    lateinit var mapper: ProductPropertyMapper
    @Autowired
    lateinit var rabbitMQSender: RabbitMQSender

    override fun add(productProperty: ProductProperty) {
        mapper.add(productProperty)
        val queueInfo = DataChange("add", "productProperty", productProperty.id, productProperty.productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun delete(id: Long) {
        mapper.delete(id)
        val queueInfo = DataChange("delete", "productProperty", id, findById(id).productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun update(productProperty: ProductProperty) {
        mapper.update(productProperty)
        val queueInfo = DataChange("update", "productProperty", productProperty.id, productProperty.productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun findById(id: Long): ProductProperty = mapper.findById(id)
}
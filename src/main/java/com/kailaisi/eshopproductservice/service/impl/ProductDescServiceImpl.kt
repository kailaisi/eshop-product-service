package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductdescservice.service.ProductDescService
import com.kailaisi.eshopproductservice.mapper.ProductDescMapper
import com.kailaisi.eshopproductservice.model.ProductDesc
import com.kailaisi.eshopproductservice.rabbitmq.DataChange
import com.kailaisi.eshopproductservice.rabbitmq.RabbitMQSender
import com.kailaisi.eshopproductservice.rabbitmq.RabbitQueue
import com.kailaisi.eshopproductservice.util.FastJsonUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductDescServiceImpl : ProductDescService {

    @Autowired
    lateinit var mapper: ProductDescMapper
    @Autowired
    lateinit var rabbitMQSender: RabbitMQSender

    override fun add(productDesc: ProductDesc) {
        mapper.add(productDesc)
        val queueInfo = DataChange("add", "productDesc", productDesc.id, productDesc.productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun delete(id: Long) {
        mapper.delete(id)
        val queueInfo = DataChange("delete", "productDesc", id, findById(id).productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun update(productDesc: ProductDesc) {
        mapper.update(productDesc)
        val queueInfo = DataChange("update", "productDesc", productDesc.id, productDesc.productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun findById(id: Long): ProductDesc = mapper.findById(id)
    override fun findByProductId(id: Long): List<ProductDesc> = mapper.findByProductId(id)

}
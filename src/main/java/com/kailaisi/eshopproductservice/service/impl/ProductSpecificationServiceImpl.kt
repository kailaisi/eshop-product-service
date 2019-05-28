package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.ProductSpecificationMapper
import com.kailaisi.eshopproductservice.model.ProductSpecification
import com.kailaisi.eshopproductservice.rabbitmq.DataChange
import com.kailaisi.eshopproductservice.rabbitmq.RabbitMQSender
import com.kailaisi.eshopproductservice.rabbitmq.RabbitQueue
import com.kailaisi.eshopproductservice.service.ProductSpecificationService
import com.kailaisi.eshopproductservice.util.FastJsonUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductSpecificationServiceImpl : ProductSpecificationService {
    @Autowired
    lateinit var mapper: ProductSpecificationMapper
    @Autowired
    lateinit var rabbitMQSender: RabbitMQSender

    override fun add(productSpecification: ProductSpecification) {
        mapper.add(productSpecification)
        val queueInfo = DataChange("add", "productSpecification", productSpecification.id, productSpecification.productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun delete(id: Long) {
        mapper.delete(id)
        val queueInfo = DataChange("delete", "productSpecification", id, findById(id).productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun update(productSpecification: ProductSpecification) {
        mapper.update(productSpecification)
        val queueInfo = DataChange("update", "productSpecification", productSpecification.id, productSpecification.productId)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun findById(id: Long): ProductSpecification = mapper.findById(id)
    override fun findByProductId(id: Long): List<ProductSpecification> =mapper.findByProductId(id)

}
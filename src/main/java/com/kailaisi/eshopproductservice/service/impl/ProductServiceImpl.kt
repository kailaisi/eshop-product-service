package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.ProductMapper
import com.kailaisi.eshopproductservice.model.Product
import com.kailaisi.eshopproductservice.rabbitmq.DataChange
import com.kailaisi.eshopproductservice.rabbitmq.RabbitMQSender
import com.kailaisi.eshopproductservice.rabbitmq.RabbitQueue
import com.kailaisi.eshopproductservice.service.ProductService
import com.kailaisi.eshopproductservice.util.FastJsonUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class ProductServiceImpl : ProductService {
    @Autowired
    lateinit var productMapper: ProductMapper
    @Autowired
    lateinit var rabbitMQSender: RabbitMQSender

    override fun add(product: Product) {
        productMapper.addProduct(product)
        val queueInfo = DataChange("add", "product", product.id,product.id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun delete(id: Long) {
        productMapper.delete(id)
        val queueInfo = DataChange("delete", "product", id,id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun update(product: Product) {
        productMapper.update(product)
        val queueInfo = DataChange("update", "product", product.id,product.id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun findById(id: Long): Product = productMapper.findById(id)
}
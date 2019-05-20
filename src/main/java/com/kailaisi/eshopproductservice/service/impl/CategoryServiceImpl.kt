package com.kailaisi.eshopproductservice.service.impl

import com.kailaisi.eshopproductservice.mapper.CategoryMapper
import com.kailaisi.eshopproductservice.model.Category
import com.kailaisi.eshopproductservice.rabbitmq.DataChange
import com.kailaisi.eshopproductservice.rabbitmq.RabbitMQSender
import com.kailaisi.eshopproductservice.rabbitmq.RabbitQueue
import com.kailaisi.eshopproductservice.service.CategoryService
import com.kailaisi.eshopproductservice.util.FastJsonUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:49
 */
@Service
class CategoryServiceImpl : CategoryService {
    @Autowired
    lateinit var categoryMapper: CategoryMapper
    @Autowired
    lateinit var rabbitMQSender: RabbitMQSender

    override fun add(category: Category) {
        categoryMapper.addCategory(category)
        val queueInfo = DataChange("add", "category", category.id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun delete(id: Long) {
        categoryMapper.delete(id)
        val queueInfo = DataChange("delete", "category", id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun update(category: Category) {
        categoryMapper.update(category)
        val queueInfo = DataChange("delete", "category", category.id)
        rabbitMQSender.send(RabbitQueue.DATA_CHANGE_QUEUE, FastJsonUtil.bean2Json(queueInfo))
    }

    override fun findById(id: Long): Category = categoryMapper.findById(id)
}
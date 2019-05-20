package com.kailaisi.eshopproductservice.rabbitmq

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/20 15:45
 */
@Component
class RabbitMQSender {
    @Autowired
    lateinit var amqpTemporal: AmqpTemplate

    fun send(queue:String,msg:String):Unit{
        amqpTemporal.convertAndSend(queue,msg)
    }
}

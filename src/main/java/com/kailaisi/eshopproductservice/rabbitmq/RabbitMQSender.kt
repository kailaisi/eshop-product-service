package com.kailaisi.eshopproductservice.rabbitmq

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import kotlin.random.Random

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/20 15:45
 */
@Component
class RabbitMQSender {
    @Autowired
    lateinit var amqpTemporal: AmqpTemplate

    fun send(queue: String, msg: String): Unit {
        var i = Random.nextInt(0, 3)
        var que = when (i) {
            0 -> RabbitQueue.DATA_CHANGE_QUEUE
            1 -> RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE
            else -> RabbitQueue.REFRESH_DATA_CHANGE_QUEUE
        }
        amqpTemporal.convertAndSend(que, msg)
    }
}

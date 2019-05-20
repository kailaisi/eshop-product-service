package com.kailaisi.eshopproductservice.rabbitmq

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/20 15:57
 */
class RabbitQueue {
    companion object {
        val DATA_CHANGE_QUEUE: String = "data-change-queue"
    }
}

/**
 * 数据修改对应的数据
 */
class DataChange(event_type: String, data_type: String, id: Long)
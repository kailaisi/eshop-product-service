package com.kailaisi.eshopproductservice.rabbitmq

/**
 *描述：rabbit消息队列
 *<p/>作者：wu
 *<br/>创建时间：2019/5/20 15:57
 */
class RabbitQueue {
    companion object {
        val DATA_CHANGE_QUEUE: String = "data-change-queue"
        val HIGH_PRIORITY_DATA_CHANGE_QUEUE: String = "high-priority-data-change-queue"
        val REFRESH_DATA_CHANGE_QUEUE: String = "refresh-data-change-queue"
    }
}

/**
 * 数据修改对应的数据
 */
class DataChange(var event_type: String, var data_type: String, var id: Long, var productId: Long?)

/**
 * 数据修改类型
 */
enum class EventType(val type: String) {
    ADD("add"),
    DELETE("delete"),
    UPDATE("update")
}
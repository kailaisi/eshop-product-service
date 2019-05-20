package com.kailaisi.eshopproductservice.model

/**
 *描述：种类
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:15
 */
class Category {
    var id: Long? = null
    lateinit var name: String
    lateinit var description: String
}

/**
 *品牌
 */
class Brand {
    var id: Long = 0
    lateinit var name: String
    lateinit var description: String
}

/**
 * 商品信息
 */
class Product {
    var id: Long = 0
    var name: String? = null
    var categoryId: Long = 0
    var brandId: Long = 0
}

/**
 * 商品详情
 */
class ProductDesc {
    var id: Long = 0
    var content: String? = null
    var productId: Long = 0
}

/**
 * 商品属性
 */
class ProductProperty {
    var id: Long = 0
    var name: String? = null
    var value: String? = null
    var productId: Long = 0
}

/**
 * 商品规格
 */
class ProductSpecification {
    var id: Long = 0
    var name: String? = null
    var value: String? = null
    var productId: Long = 0
}

/**
 * 商品价格
 */
class ProductPrice {
    var id: Long = 0
    var value: Double = 0.0
    var productId: Long = 0
}
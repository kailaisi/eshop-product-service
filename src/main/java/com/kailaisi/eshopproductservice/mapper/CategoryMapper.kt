package com.kailaisi.eshopproductservice.mapper

import com.kailaisi.eshopproductservice.model.Category
import org.apache.ibatis.annotations.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/16 11:24
 */
@Mapper
interface CategoryMapper {
    @Insert("Insert into category(name,description) values(#{name},#{description})")
    fun addCategory(category: Category)

    @Delete("delete from category where id=#{id}")
    fun delete(id: Long)

    @Update("update category set name=#{name},description=#{description} where id=#{id}")
    fun update(category: Category)

    @Select("select * from category where id=#{id}")
    fun findById(id: Long): Category
}
package com.wuqy.dao.mapper;

import com.wuqy.common.entity.db.TOrder;
import com.wuqy.common.entity.db.TOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int countByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int deleteByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int insert(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int insertSelective(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    List<TOrder> selectByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    TOrder selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int updateByPrimaryKeySelective(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Jan 07 15:50:43 CST 2021
     */
    int updateByPrimaryKey(TOrder record);
}
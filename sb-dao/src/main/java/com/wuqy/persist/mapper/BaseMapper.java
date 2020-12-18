package com.wuqy.persist.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tanguocan on 2019/11/14
 */
public interface BaseMapper<BEAN,BEAN_EXAMPLE,KEYTYPE> {
    int countByExample(BEAN_EXAMPLE example);

    int deleteByExample(BEAN_EXAMPLE example);
    int deleteByPrimaryKey(KEYTYPE id);

    int insert(BEAN record);

    int insertSelective(BEAN record);

    List<BEAN> selectByExample(BEAN_EXAMPLE example);

    BEAN selectByPrimaryKey(KEYTYPE id);

    int updateByExampleSelective(@Param("record") BEAN record, @Param("example") BEAN_EXAMPLE example);

    int updateByExample(@Param("record") BEAN record, @Param("example") BEAN_EXAMPLE example);

    int updateByPrimaryKeySelective(BEAN record);

    int updateByPrimaryKey(BEAN record);
}

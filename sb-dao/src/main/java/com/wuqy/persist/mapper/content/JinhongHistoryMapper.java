package com.wuqy.persist.mapper.content;

import java.util.List;

import com.wuqy.common.entity.content.JinhongHistory;
import com.wuqy.common.entity.content.JinhongHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface JinhongHistoryMapper {
    int countByExample(JinhongHistoryExample example);

    int deleteByExample(JinhongHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinhongHistory record);

    int insertListSelective(@Param("record") JinhongHistory record, @Param("records") List<JinhongHistory> records);

    int replaceListSelective(@Param("record") JinhongHistory record, @Param("records") List<JinhongHistory> records);

    int replaceSelective(JinhongHistory record);

    int insertOnDuplicateKeySelective(JinhongHistory record);

    int insertListOnDuplicateKeySelective(@Param("record") JinhongHistory record, @Param("records") List<JinhongHistory> records);

    int insertSelective(JinhongHistory record);

    List<JinhongHistory> selectByExample(JinhongHistoryExample example);

    JinhongHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinhongHistory record, @Param("example") JinhongHistoryExample example);

    int updateByExample(@Param("record") JinhongHistory record, @Param("example") JinhongHistoryExample example);

    int updateByPrimaryKeySelective(JinhongHistory record);

    int updateByPrimaryKey(JinhongHistory record);


    @Select({
            "select",
            "*",
            "from jinhong_history",
            "order by rand() limit #{num}"
    })
    List<JinhongHistory> selectRandom(int num);
}
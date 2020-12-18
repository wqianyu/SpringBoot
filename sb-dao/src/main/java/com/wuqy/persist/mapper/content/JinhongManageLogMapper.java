package com.wuqy.persist.mapper.content;

import com.wuqy.common.entity.content.JinhongManageLog;
import com.wuqy.common.entity.content.JinhongManageLogExample;
import com.wuqy.persist.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JinhongManageLogMapper extends BaseMapper<JinhongManageLog, JinhongManageLogExample, Integer> {
    int countByExample(JinhongManageLogExample example);

    int deleteByExample(JinhongManageLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinhongManageLog record);

    int insertListSelective(@Param("record") JinhongManageLog record, @Param("records") List<JinhongManageLog> records);

    int replaceListSelective(@Param("record") JinhongManageLog record, @Param("records") List<JinhongManageLog> records);

    int replaceSelective(JinhongManageLog record);

    int insertOnDuplicateKeySelective(JinhongManageLog record);

    int insertListOnDuplicateKeySelective(@Param("record") JinhongManageLog record, @Param("records") List<JinhongManageLog> records);

    int insertSelective(JinhongManageLog record);

    List<JinhongManageLog> selectByExample(JinhongManageLogExample example);

    JinhongManageLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinhongManageLog record, @Param("example") JinhongManageLogExample example);

    int updateByExample(@Param("record") JinhongManageLog record, @Param("example") JinhongManageLogExample example);

    int updateByPrimaryKeySelective(JinhongManageLog record);

    int updateByPrimaryKey(JinhongManageLog record);

    @Select({
            "select",
            "min(create_time) minTime, max(create_time) maxTime",
            "from jinhong_manage_log"
    })
    JinhongManageLog selectMinMaxTime();
}
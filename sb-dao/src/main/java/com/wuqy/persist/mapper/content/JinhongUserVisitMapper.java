package com.wuqy.persist.mapper.content;

import com.wuqy.common.entity.content.JinhongUserVisit;
import com.wuqy.common.entity.content.JinhongUserVisitExample;
import com.wuqy.persist.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JinhongUserVisitMapper extends BaseMapper<JinhongUserVisit, JinhongUserVisitExample, Integer> {
    int countByExample(JinhongUserVisitExample example);

    int deleteByExample(JinhongUserVisitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinhongUserVisit record);

    int insertListSelective(@Param("record") JinhongUserVisit record, @Param("records") List<JinhongUserVisit> records);

    int replaceListSelective(@Param("record") JinhongUserVisit record, @Param("records") List<JinhongUserVisit> records);

    int replaceSelective(JinhongUserVisit record);

    int insertOnDuplicateKeySelective(JinhongUserVisit record);

    int insertListOnDuplicateKeySelective(@Param("record") JinhongUserVisit record, @Param("records") List<JinhongUserVisit> records);

    int insertSelective(JinhongUserVisit record);

    List<JinhongUserVisit> selectByExample(JinhongUserVisitExample example);

    JinhongUserVisit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinhongUserVisit record, @Param("example") JinhongUserVisitExample example);

    int updateByExample(@Param("record") JinhongUserVisit record, @Param("example") JinhongUserVisitExample example);

    int updateByPrimaryKeySelective(JinhongUserVisit record);

    int updateByPrimaryKey(JinhongUserVisit record);

    @Select({
            "select",
            "min(create_time) minTime, max(create_time) maxTime",
            "from jinhong_user_visit"
    })
    JinhongUserVisit selectMinMaxTime();
}
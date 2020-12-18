package com.wuqy.persist.mapper.content;

import com.wuqy.common.entity.content.JinhongWords;
import com.wuqy.common.entity.content.JinhongWordsExample;
import com.wuqy.persist.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JinhongWordsMapper extends BaseMapper<JinhongWords, JinhongWordsExample, Integer> {
    int countByExample(JinhongWordsExample example);

    int deleteByExample(JinhongWordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinhongWords record);

    int insertListSelective(@Param("record") JinhongWords record, @Param("records") List<JinhongWords> records);

    int replaceListSelective(@Param("record") JinhongWords record, @Param("records") List<JinhongWords> records);

    int replaceSelective(JinhongWords record);

    int insertOnDuplicateKeySelective(JinhongWords record);

    int insertListOnDuplicateKeySelective(@Param("record") JinhongWords record, @Param("records") List<JinhongWords> records);

    int insertSelective(JinhongWords record);

    List<JinhongWords> selectByExample(JinhongWordsExample example);

    JinhongWords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinhongWords record, @Param("example") JinhongWordsExample example);

    int updateByExample(@Param("record") JinhongWords record, @Param("example") JinhongWordsExample example);

    int updateByPrimaryKeySelective(JinhongWords record);

    int updateByPrimaryKey(JinhongWords record);
}
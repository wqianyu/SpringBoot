package com.wuqy.persist.mapper.content;

import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.entity.content.JinhongAccountExample;
import com.wuqy.persist.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JinhongAccountMapper extends BaseMapper<JinhongAccount, JinhongAccountExample, Integer> {
    int countByExample(JinhongAccountExample example);

    int deleteByExample(JinhongAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinhongAccount record);

    int insertListSelective(@Param("record") JinhongAccount record, @Param("records") List<JinhongAccount> records);

    int replaceListSelective(@Param("record") JinhongAccount record, @Param("records") List<JinhongAccount> records);

    int replaceSelective(JinhongAccount record);

    int insertOnDuplicateKeySelective(JinhongAccount record);

    int insertListOnDuplicateKeySelective(@Param("record") JinhongAccount record, @Param("records") List<JinhongAccount> records);

    int insertSelective(JinhongAccount record);

    List<JinhongAccount> selectByExample(JinhongAccountExample example);

    JinhongAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinhongAccount record, @Param("example") JinhongAccountExample example);

    int updateByExample(@Param("record") JinhongAccount record, @Param("example") JinhongAccountExample example);

    int updateByPrimaryKeySelective(JinhongAccount record);

    int updateByPrimaryKey(JinhongAccount record);

    @Select({
            "select",
            "*",
            "from jinhong_account",
            "order by rand() limit 1"
    })
    JinhongAccount selectRandom1();
}
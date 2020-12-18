package com.wuqy.service.word;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.wuqy.common.entity.content.JinhongWords;
import com.wuqy.common.entity.content.JinhongWordsExample;
import com.wuqy.common.vo.Page;
import com.wuqy.persist.mapper.BaseMapper;
import com.wuqy.persist.mapper.content.JinhongWordsMapper;
import com.wuqy.service.common.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关键词相关
 * @author wuqy
 * 2020-11-11
 */
@Service
public class WordService extends AbstractService<JinhongWords, JinhongWordsExample, Integer> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JinhongWordsMapper wordsMapper;

    public int insert(JinhongWords entity) {
        return wordsMapper.insert(entity);
    }

    public int update(JinhongWords entity) {
        return wordsMapper.updateByPrimaryKey(entity);
    }

    public int delete(Integer id) {
        return wordsMapper.deleteByPrimaryKey(id);
    }

    public JinhongWords getById(Integer id) {
        return wordsMapper.selectByPrimaryKey(id);
    }

    public List<JinhongWords> select() {
        JinhongWordsExample example = new JinhongWordsExample();
        example.setOrderByClause(" create_time desc");
        return wordsMapper.selectByExample(example);
    }

    @Override
    protected BaseMapper<JinhongWords, JinhongWordsExample, Integer> getRepository() {
        return wordsMapper;
    }

    @Override
    public Page<JinhongWords> page(JinhongWordsExample example, int page, int pageSize) {
        example.setOrderByClause(" id desc");
        com.github.pagehelper.Page<JinhongWords> pageResult = PageHelper.startPage(page, pageSize).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                getRepository().selectByExample(example);
            }
        });
        return new Page<>(pageResult.getResult(), pageResult.getTotal());
    }
}

package com.wuqy.service.visit;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.wuqy.common.entity.content.JinhongUserVisit;
import com.wuqy.common.entity.content.JinhongUserVisitExample;
import com.wuqy.common.vo.Page;
import com.wuqy.persist.mapper.BaseMapper;
import com.wuqy.persist.mapper.content.JinhongUserVisitMapper;
import com.wuqy.service.common.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 访问日志相关
 * @author wuqy
 * 2020-11-11
 */
@Service
public class VisitLogService extends AbstractService<JinhongUserVisit, JinhongUserVisitExample, Integer> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JinhongUserVisitMapper userVisitMapper;

    public int insert(JinhongUserVisit entity) {
        return userVisitMapper.insert(entity);
    }

    public int update(JinhongUserVisit entity) {
        return userVisitMapper.updateByPrimaryKey(entity);
    }

    public int delete(Integer id) {
        return userVisitMapper.deleteByPrimaryKey(id);
    }

    public JinhongUserVisit getById(Integer id) {
        return userVisitMapper.selectByPrimaryKey(id);
    }

    public List<JinhongUserVisit> select() {
        JinhongUserVisitExample example = new JinhongUserVisitExample();
        example.setOrderByClause(" id desc");
        return userVisitMapper.selectByExample(example);
    }

    @Override
    protected BaseMapper<JinhongUserVisit, JinhongUserVisitExample, Integer> getRepository() {
        return userVisitMapper;
    }

    @Override
    public Page<JinhongUserVisit> page(JinhongUserVisitExample example, int page, int pageSize) {
        example.setOrderByClause(" create_time desc");
        com.github.pagehelper.Page<JinhongUserVisit> pageResult = PageHelper.startPage(page, pageSize).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                getRepository().selectByExample(example);
            }
        });
        List<JinhongUserVisit> list = pageResult.getResult();
        for(int seq = 0; seq < list.size(); seq++) {
            list.get(seq).setId(seq+1);
        }
        return new Page<>(pageResult.getResult(), pageResult.getTotal());
    }
}

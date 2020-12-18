package com.wuqy.service.account;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.entity.content.JinhongAccountExample;
import com.wuqy.common.vo.Page;
import com.wuqy.persist.mapper.BaseMapper;
import com.wuqy.persist.mapper.content.JinhongAccountMapper;
import com.wuqy.service.common.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<JinhongAccount, JinhongAccountExample, Integer> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JinhongAccountMapper accountMapper;

    @Override
    protected BaseMapper<JinhongAccount, JinhongAccountExample, Integer> getRepository() {
        return accountMapper;
    }

    @Override
    public Page<JinhongAccount> page(JinhongAccountExample example, int page, int pageSize) {
        example.setOrderByClause(" id desc");
        com.github.pagehelper.Page<JinhongAccount> pageResult = PageHelper.startPage(page, pageSize).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                getRepository().selectByExample(example);
            }
        });
        return new Page<>(pageResult.getResult(), pageResult.getTotal());
    }
}

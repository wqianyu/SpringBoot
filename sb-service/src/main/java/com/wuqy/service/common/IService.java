package com.wuqy.service.common;


import com.wuqy.common.vo.Page;

import java.util.List;

/**
 * @author jiangty
 *
 * @date 2019年2月20日
 */
public interface IService<BEAN, BEAN_EXAMPLE,KEYTYPE> {
    /**
     * 添加记录接口.
     *
     * @param bean
     *            参数类型:如User、Article、Comment等
     * @return 添加成功返回true，记录已存在不想抛异常可返回false(如使用insert ignore into)，其他情况抛异常.
     */
    BEAN add(BEAN bean);

    /**
     * 根据主键获取单条记录(不返回已标记删除的记录).
     *
     * @param key
     *            主键类型:如Integer、Long、String等
     *
     * @return 记录存在返回对象，不存在返回null，其他情况抛异常.
     */
    BEAN get(KEYTYPE key);

    int delete(BEAN_EXAMPLE bean);

    int deleteByPrimaryKey(KEYTYPE key);

    int updateByPrimaryKeySelective(BEAN bean);

    List<BEAN> list(BEAN_EXAMPLE bean);

    Page<BEAN> page(BEAN_EXAMPLE bean, int page, int pageSize);

}

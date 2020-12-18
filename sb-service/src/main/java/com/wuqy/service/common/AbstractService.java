package com.wuqy.service.common;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.wuqy.common.vo.Page;
import com.wuqy.persist.mapper.BaseMapper;

import java.util.List;

/**
 * @author jiangty
 *
 * @date 2019年2月20日
 */
public abstract class AbstractService<BEAN, BEAN_EXAMPLE,KEYTYPE>  implements IService<BEAN, BEAN_EXAMPLE,KEYTYPE>{
	protected abstract BaseMapper<BEAN,BEAN_EXAMPLE,KEYTYPE> getRepository();

	@Override
	public BEAN add(BEAN bean) {
		int insert = getRepository().insert(bean);
		return bean;
	}

	@Override
	public BEAN get(KEYTYPE key) {
		return getRepository().selectByPrimaryKey(key);
	}

	@Override
	public int delete(BEAN_EXAMPLE bean) {
		return getRepository().deleteByExample(bean);
	}


	@Override
	public int deleteByPrimaryKey(KEYTYPE key) {
		return getRepository().deleteByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(BEAN bean) {
		return getRepository().updateByPrimaryKeySelective(bean);
	}

	@Override
	public List<BEAN> list(BEAN_EXAMPLE bean) {
		return getRepository().selectByExample(bean);
	}

	@Override
	public Page<BEAN> page(BEAN_EXAMPLE bean, int page, int pageSize) {
		com.github.pagehelper.Page<BEAN> pageResult = PageHelper.startPage(page, pageSize).doSelectPage(new ISelect() {
			@Override
			public void doSelect() {
				getRepository().selectByExample(bean);
			}
		});
		return new Page<>(pageResult.getResult(),pageResult.getTotal());
	}
}

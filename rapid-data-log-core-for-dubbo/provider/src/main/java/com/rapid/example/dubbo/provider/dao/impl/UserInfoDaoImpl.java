/**
 *
 */
package com.rapid.example.dubbo.provider.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Repository;

import com.rapid.example.dubbo.provider.dao.IUserInfoDao;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:58:23
 *
 */
@Repository
public class UserInfoDaoImpl implements IUserInfoDao {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.dao.impl.IUserInfoDao#queryByName(java.
	 * lang.String)
	 */
	@Override
	public boolean queryByName(final String userName) {
		try {
			TimeUnit.SECONDS.sleep(1L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		return true;
	}

}

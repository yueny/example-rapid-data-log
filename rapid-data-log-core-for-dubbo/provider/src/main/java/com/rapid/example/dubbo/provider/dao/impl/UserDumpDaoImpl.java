/**
 *
 */
package com.rapid.example.dubbo.provider.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Repository;

import com.rapid.example.dubbo.provider.dao.IUserDumpDao;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月2日 上午11:09:28
 *
 */
@Repository
public class UserDumpDaoImpl implements IUserDumpDao {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.dao.IUserDumpDao#dump(java.lang.String)
	 */
	@Override
	public boolean dump(final String userName) {
		try {
			TimeUnit.MILLISECONDS.sleep(200L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.dao.IUserDumpDao#dumpForError(java.lang.
	 * String)
	 */
	@Override
	public boolean dumpForError(final String userName) {
		throw new IllegalArgumentException("操作异常！");
	}

}

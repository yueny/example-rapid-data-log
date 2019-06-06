/**
 *
 */
package com.rapid.example.data.log.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Repository;

import com.rapid.example.data.log.dao.IUserDumpDao;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月2日 上午11:09:28
 *
 */
@Repository
@Slf4j
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
			TimeUnit.MILLISECONDS.sleep(50L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		log.info("数据库dump了~");
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
		log.error("数据库dump操作异常~");
		throw new IllegalArgumentException("操作异常！");
	}

}

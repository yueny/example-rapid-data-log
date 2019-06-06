/**
 *
 */
package com.rapid.example.data.log.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.example.data.log.dao.IUserDumpDao;
import com.rapid.example.data.log.service.IUserLoginHolderService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午9:01:26
 *
 */
@Service
@Slf4j
public class UserLoginHolderServiceImpl implements IUserLoginHolderService {
	@Autowired
	private IUserDumpDao userDumpDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.service.IUserLoginHolderService#dump(
	 * java.lang.String)
	 */
	@Override
	public boolean dump(final String name) {
		try {
			TimeUnit.MILLISECONDS.sleep(800L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		log.info("服务正在dump~");

		return userDumpDao.dump(name);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.service.IUserLoginHolderService#holder(
	 * java.lang.String)
	 */
	@Override
	public void holder(final String name) {
		try {
			TimeUnit.MILLISECONDS.sleep(150L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		log.info("服务holder住了~");
	}

}

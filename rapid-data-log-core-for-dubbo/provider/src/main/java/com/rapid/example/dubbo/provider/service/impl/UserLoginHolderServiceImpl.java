/**
 *
 */
package com.rapid.example.dubbo.provider.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.example.dubbo.provider.dao.IUserDumpDao;
import com.rapid.example.dubbo.provider.service.IUserLoginHolderService;
import com.yueny.rapid.topic.profiler.ProfilerLog;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午9:01:26
 *
 */
@Service
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
	// @ProfilerLog
	public boolean dump(final String name) {
		try {
			TimeUnit.MILLISECONDS.sleep(800L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

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
	@ProfilerLog
	public void holder(final String name) {
		try {
			TimeUnit.MILLISECONDS.sleep(150L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

}

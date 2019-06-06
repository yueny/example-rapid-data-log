/**
 *
 */
package com.rapid.example.dubbo.provider.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.rapid.example.dubbo.provider.service.IUserLoginEnableService;
import com.yueny.rapid.topic.profiler.ProfilerLog;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:48:45
 *
 */
@Service
public class UserLoginEnableServiceImpl implements IUserLoginEnableService {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.service.UserLoginEnableService#enable()
	 */
	@Override
	@ProfilerLog
	public boolean enable(final String name, final Long delay) {
		try {
			TimeUnit.MILLISECONDS.sleep(600L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		return true;
	}

}

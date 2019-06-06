/**
 *
 */
package com.rapid.example.dubbo.provider.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.example.dubbo.provider.dao.IUserInfoDao;
import com.rapid.example.dubbo.provider.service.IUserInfoService;
import com.rapid.example.dubbo.provider.service.IUserLoginHolderService;
import com.yueny.rapid.topic.profiler.ProfilerLog;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:42:42
 *
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
	@Autowired
	private IUserInfoDao userInfoDao;
	@Autowired
	private IUserLoginHolderService userLoginHolderService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.service.IUserInfoService#queryByName(
	 * java.lang.String)
	 */
	@Override
	@ProfilerLog
	public boolean queryByName(final String userName) {
		try {
			TimeUnit.MILLISECONDS.sleep(300L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		final boolean rs = userInfoDao.queryByName(userName);

		userLoginHolderService.holder(userName);

		return rs;
	}

}

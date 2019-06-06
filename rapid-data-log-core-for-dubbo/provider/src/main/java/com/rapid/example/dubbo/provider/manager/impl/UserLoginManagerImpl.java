/**
 *
 */
package com.rapid.example.dubbo.provider.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.example.dubbo.provider.manager.IUserLoginManager;
import com.rapid.example.dubbo.provider.service.IUserInfoService;
import com.rapid.example.dubbo.provider.service.IUserLoginEnableService;
import com.rapid.example.dubbo.provider.service.IUserLoginHolderService;
import com.yueny.rapid.topic.profiler.ProfilerLog;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:53:03
 *
 */
@Service
public class UserLoginManagerImpl implements IUserLoginManager {
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IUserLoginEnableService userLoginEnableService;
	@Autowired
	private IUserLoginHolderService userLoginHolderService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.manager.impl.IUserLoginManager#login()
	 */
	@Override
	@ProfilerLog
	public boolean login(final String userName) {
		final boolean r = userLoginEnableService.enable(userName, 5L);
		if (!r) {
			return r;
		}

		final boolean ts = userInfoService.queryByName(userName);
		if (!ts) {
			return ts;
		}

		// 未被@ProfilerLog统计的耗时，均会被加入到本方法内
		return userLoginHolderService.dump(userName);
	}

}

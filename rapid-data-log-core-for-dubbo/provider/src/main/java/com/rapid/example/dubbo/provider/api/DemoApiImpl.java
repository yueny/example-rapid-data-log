/**
 *
 */
package com.rapid.example.dubbo.provider.api;

import org.springframework.beans.factory.annotation.Autowired;

import com.rapid.example.dubbo.provider.manager.IUserLoginManager;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月2日 下午6:40:10
 *
 */
@Slf4j
public class DemoApiImpl implements DemoApi {
	@Autowired
	private IUserLoginManager userLoginManager;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.dubbo.provider.api.DemoApi#queryById(java.lang.Long)
	 */
	@Override
	// @ProfilerLog
	public String queryById(final Long id) {
		userLoginManager.login("hello");

		log.info("queryById");
		return "queryById";
	}

}

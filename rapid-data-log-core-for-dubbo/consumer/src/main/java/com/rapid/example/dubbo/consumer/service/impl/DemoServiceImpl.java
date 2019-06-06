/**
 *
 */
package com.rapid.example.dubbo.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.example.dubbo.consumer.service.IDemoService;
import com.rapid.example.dubbo.provider.api.DemoApi;
import com.yueny.rapid.topic.profiler.ProfilerLog;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月2日 下午7:24:18
 *
 */
@Service
public class DemoServiceImpl implements IDemoService {
	@Autowired
	private DemoApi demoApi;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.dubbo.consumer.service.IDemoService#queryById(java.lang
	 * .Long)
	 */
	@Override
	@ProfilerLog
	public String queryById(final Long id) {
		return demoApi.queryById(5L);
	}

}

/**
 *
 */
package com.rapid.example.data.log.integration.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.rapid.example.data.log.integration.IUserIntegration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月3日 下午6:24:42
 *
 */
@Service
@Slf4j
public class UserIntegrationImpl implements IUserIntegration {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.rapid.example.topic.profiler.integration.IUserIntegration#
	 * queryDistByCode(java.lang.String)
	 */
	@Override
	public Long queryDistByCode(final String code) {
		try {
			TimeUnit.MILLISECONDS.sleep(800L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		log.info("根据code查询dist~");
		return 88L;
	}

}

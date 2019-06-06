/**
 *
 */
package com.rapid.example.data.log.manager.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.example.data.log.integration.IUserIntegration;
import com.rapid.example.data.log.manager.IUserLoginDelegateManager;
import com.rapid.example.data.log.service.IUserLoginHolderService;
import com.yueny.rapid.data.log.trace.support.ExecutorDelegate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:53:03
 *
 */
@Service
@Slf4j
public class UserLoginDelegateManagerImpl implements IUserLoginDelegateManager {
	private final ExecutorService executorService = Executors.newFixedThreadPool(5);
	private ExecutorDelegate executorDelegate=new ExecutorDelegate(executorService);
	
	@Autowired
	private IUserIntegration userIntegration;
	@Autowired
	private IUserLoginHolderService userLoginHolderService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.rapid.example.topic.profiler.manager.impl.IUserLoginManager#login()
	 */
	@Override
	public boolean login(final String userName) {
		log.info("{}/用户{}尝试进行登录操作~", Thread.currentThread().getId(), userName);

		final Long ls = userIntegration.queryDistByCode(userName);
		if (ls == 0) {
			return false;
		}

		final CountDownLatch latch = new CountDownLatch(4);

		executorDelegate.execute(new Runnable() {
			@Override
			public void run() {
				// 想测试并发，在并发中加入适当的同步操作是无法避免的，只能减少,在这，只是做了一个简单的countdown，影响不大
				latch.countDown();

				log.info("{}/1子线程进行日志同步了-}~", Thread.currentThread().getId());
			}
		});

		executorDelegate.execute(new Runnable() {
			@Override
			public void run()  {
				latch.countDown();

				log.info("{}/1子线程进行数据同步了~", Thread.currentThread().getId());

				executorDelegate.execute(new Runnable() {
					@Override
					public void run() {
						// 想测试并发，在并发中加入适当的同步操作是无法避免的，只能减少,在这，只是做了一个简单的countdown，影响不大
						latch.countDown();

						log.info("{}/2子线程进行日志同步了-~", Thread.currentThread().getId());
						
						executorDelegate.execute(new Runnable() {
							@Override
							public void run() {
								// 想测试并发，在并发中加入适当的同步操作是无法避免的，只能减少,在这，只是做了一个简单的countdown，影响不大
								latch.countDown();

								log.info("{}/3子线程进行日志同步了-~", Thread.currentThread().getId());
							}
						});
					}
				});
			}
		});
		
		try {
			latch.await();
		} catch (final InterruptedException e) {
			log.error("exception:", e);
		}

		final boolean ts = userLoginHolderService.dump(userName);
		if (!ts) {
			return ts;
		}

		userLoginHolderService.holder(userName);
		return ts;
	}

}

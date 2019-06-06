/**
 *
 */
package com.rapid.example.data.log.manager.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid.example.data.log.integration.IUserIntegration;
import com.rapid.example.data.log.manager.IUserLoginManager;
import com.rapid.example.data.log.service.IUserLoginHolderService;
import com.yueny.rapid.data.log.trace.concurrent.MDCCallable;
import com.yueny.rapid.data.log.trace.concurrent.MDCRunnable;
import com.yueny.superclub.api.constant.ConventionsX;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:53:03
 *
 */
@Service
@Slf4j
public class UserLoginManagerImpl implements IUserLoginManager {
	private final ExecutorService executorService = Executors.newFixedThreadPool(5);

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

		executorService.submit(new MDCRunnable() {
			@Override
			public void runner() {
				// 想测试并发，在并发中加入适当的同步操作是无法避免的，只能减少,在这，只是做了一个简单的countdown，影响不大
				latch.countDown();

				log.info("{}/1子线程进行日志同步了-找到当前子线程{}~", Thread.currentThread().getId(),
						MDC.get(ConventionsX.CTX_LOG_ID_MDC));
			}
		});

		final Future<String> futureData = executorService.submit(new MDCCallable<String>() {
			@Override
			public String runner() throws Exception {
				latch.countDown();

				log.info("{}/1子线程进行数据同步了-找到当前子线程{}~", Thread.currentThread().getId(),
						MDC.get(ConventionsX.CTX_LOG_ID_MDC));

				executorService.submit(new MDCRunnable() {
					@Override
					public void runner() {
						// 想测试并发，在并发中加入适当的同步操作是无法避免的，只能减少,在这，只是做了一个简单的countdown，影响不大
						latch.countDown();

						log.info("{}/2子线程进行日志同步了-找到当前子线程{}~", Thread.currentThread().getId(),
								MDC.get(ConventionsX.CTX_LOG_ID_MDC));

						executorService.submit(new MDCRunnable() {
							@Override
							public void runner() {
								// 想测试并发，在并发中加入适当的同步操作是无法避免的，只能减少,在这，只是做了一个简单的countdown，影响不大
								latch.countDown();

								log.info("{}/3子线程进行日志同步了-找到当前子线程{}~", Thread.currentThread().getId(),
										MDC.get(ConventionsX.CTX_LOG_ID_MDC));
							}
						});
					}
				});

				return "OK";
			}
		});

		try {
			latch.await();
		} catch (final InterruptedException e) {
			log.error("exception:", e);
		}

		// try {
		// System.out.println(futureData.get());
		// } catch (InterruptedException | ExecutionException e) {
		// e.printStackTrace();
		// }

		final boolean ts = userLoginHolderService.dump(userName);
		if (!ts) {
			return ts;
		}

		userLoginHolderService.holder(userName);
		return ts;
	}

}

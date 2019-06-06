/**
 *
 */
package com.rapid.example.data.log.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

import com.yueny.rapid.message.email.sender.EmailTemplateSenderHelper;
import com.yueny.rapid.message.email.sender.EmailType;
import com.yueny.rapid.message.email.sender.core.EmailMessageForTemplate;
import com.yueny.rapid.message.email.sender.entity.ThreadEmailEntry;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年10月27日 下午7:00:21
 *
 */
@Slf4j
// @Component
public class HealthyStepJock {
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 默认的执行方式是串行执行
	 *
	 * @Scheduled 注解用于标注这个方法是一个定时任务的方法，有多种配置可选。<br>
	 *            cron支持cron表达式，指定任务在特定时间执行；<br>
	 *            fixedRate以特定频率执行任务， 单位 毫秒milliseconds；<br>
	 *            fixedRateString以string的形式配置执行频率。
	 */
	@Scheduled(fixedRate = 3000)
	public void doSomething() {
		// step 5
		send("yuanyang", "yuany@aicaigroup.com");
	}

	private boolean send(final String userName, final String to) {
		final EmailMessageForTemplate emailMessage = new EmailMessageForTemplate("demo", "库自带的模板", "测试html信息");

		emailMessage.getParameters().put("userName", userName);
		emailMessage.to(to);
		emailMessage.setType(EmailType.HTML);

		try {
			final ThreadEmailEntry entry = EmailTemplateSenderHelper.send(emailMessage);

			log.info("【StepJock】邮件发送结果：{},The time is now ：{}.", entry, dateFormat.format(new Date()));
		} catch (final Exception e) {
			log.error("【StepJock】 超过超时，下次继续.", e);
		}

		return true;
	}

}

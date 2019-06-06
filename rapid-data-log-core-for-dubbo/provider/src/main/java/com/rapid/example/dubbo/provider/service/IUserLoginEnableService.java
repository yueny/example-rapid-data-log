/**
 *
 */
package com.rapid.example.dubbo.provider.service;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:48:16
 *
 */
public interface IUserLoginEnableService {
	/**
	 * 执行操作
	 */
	boolean enable(String name, Long delay);

}

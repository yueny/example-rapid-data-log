/**
 *
 */
package com.rapid.example.dubbo.provider.dao;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:58:08
 *
 */
public interface IUserInfoDao {
	/**
	 * 执行操作
	 */
	boolean queryByName(String userName);
}

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
public interface IUserDumpDao {
	/**
	 * dump操作
	 */
	boolean dump(String userName);

	boolean dumpForError(final String userName);
}

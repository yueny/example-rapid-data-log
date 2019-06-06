package com.rapid.example.data.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rapid.example.data.log.manager.IUserLoginDelegateManager;
import com.rapid.example.data.log.manager.IUserLoginManager;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@RestController
public class DemoController {
	@Autowired
	private IUserLoginDelegateManager userLoginDelegateManager;
	@Autowired
	private IUserLoginManager userLoginManager;

	/**
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String bar() {
		userLoginManager.login("hello");

		return "welcome";
	}

	/**
	 *
	 */
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	public String welcome() {
		userLoginDelegateManager.login("welcome");

		return "welcome";
	}
}

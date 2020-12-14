package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.TestService;

//import com.service.testService;

@Controller
public class testController {

	@Autowired
	private TestService testService;

	@ResponseBody
	@RequestMapping("/test2")
	public void test() {

		System.out.println("val : ");
		System.out.println(testService.test());
	}
}

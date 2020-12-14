package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TestDAO;
import com.mybatis.mappers.Test;

@Service
public class TestService {

	@Autowired
	private TestDAO testDAO;

	public String test() {
		return testDAO.test();
	}
}

package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.mappers.Test;

@Repository
public class TestDAO {

	@Autowired
	private Test test;

	public String test() {
		return test.test();
	}

}

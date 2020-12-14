package com.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository(value="Test")
@Mapper
public interface Test {

	public String test();
}

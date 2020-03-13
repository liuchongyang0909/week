package com.lcy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lcy.pojo.Address;
import com.lcy.pojo.Area;

public interface AreaMapper {

	List<Address> getAddressList();

	List<Area> findProvince();

	List<Area> findNext(@Param("id")Integer id);
}

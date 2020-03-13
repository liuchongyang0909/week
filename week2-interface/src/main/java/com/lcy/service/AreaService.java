package com.lcy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lcy.pojo.Address;
import com.lcy.pojo.Area;

public interface AreaService {

	PageInfo<Address> getAddressList(Integer pageNum);

	List<Area> findProvince();

	List<Area> findNext(Integer id);

}

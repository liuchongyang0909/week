package com.lcy.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.mapper.AreaMapper;
import com.lcy.pojo.Address;
import com.lcy.pojo.Area;
import com.lcy.service.AreaService;

@Service(interfaceClass = AreaService.class)
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaMapper mapper;

	@Override
	public PageInfo<Address> getAddressList(Integer pageNum) {
		PageHelper.startPage(pageNum, 3);
		
		List<Address> list = mapper.getAddressList();
		
		PageInfo<Address> info = new PageInfo<Address>(list);
		
		return info;
	}

	@Override
	public List<Area> findProvince() {
		return mapper.findProvince();
	}

	@Override
	public List<Area> findNext(Integer id) {
		return mapper.findNext(id);
	}	
}

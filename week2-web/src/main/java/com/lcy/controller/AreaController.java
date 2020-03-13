package com.lcy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lcy.pojo.Address;
import com.lcy.pojo.Area;
import com.lcy.service.AreaService;

@Controller
public class AreaController {
	@Reference(url = "dubbo://127.0.0.1:20881")
	AreaService service;
	
	@RequestMapping("list")
	public String getAddressList(Model m, @RequestParam(defaultValue = "1")Integer pageNum) {
		PageInfo<Address> info = service.getAddressList(pageNum);
		
		m.addAttribute("info", info);
		
		return "list";
	}
	
	@ResponseBody
	@RequestMapping("findProvince")
	public void findProvince(HttpServletResponse response, Model m) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Area> cityList = service.findProvince();
		JSONArray parseArray = JSONArray.parseArray(JSON.toJSONString(cityList));
		response.getWriter().print(parseArray.toString());
		m.addAttribute("parseArray", parseArray);
	}
	
	@ResponseBody
	@RequestMapping("findNext")
	public void findNext(HttpServletResponse response, Model m, Integer id) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		
		List<Area> cityList = service.findNext(id);
		
		JSONArray array = JSONArray.parseArray(JSON.toJSONString(cityList));
		response.getWriter().print(array.toString());
		
		m.addAttribute("array", array);
	}
}

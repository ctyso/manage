package com.manage.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annotation.Json;
import com.manage.sys.entity.Module;
import com.manage.sys.service.impl.ModuleService;

@Controller
@RequestMapping("/Module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/findAll.htm")
	@Json
	public Object findAll(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Module> list = moduleService.findAll();
			map.put("data", list);
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
        return map;
	}
}

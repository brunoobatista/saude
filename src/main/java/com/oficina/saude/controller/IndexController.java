package com.oficina.saude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("/index/Index");
		return mv;
	}
	
}
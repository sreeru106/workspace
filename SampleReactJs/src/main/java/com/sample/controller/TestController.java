package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestController {
//	@Autowired
//	testRepository test22;
//	@Autowired
//	testEntityRepo test;
//	
	//@Transactional
	@RequestMapping(value="/registraion.html", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
//		System.out.println("ssss");
//		test2 test_2= new test2("1235456454445554545454545454");
//		testEntity testentity = new testEntity("name");
//		System.out.println("ssss");
//		test.save(testentity);
//		test22.save(test_2);
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "Hello";
	}

}

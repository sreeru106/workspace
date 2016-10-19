package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import com.sample.bean.Employee;
import com.sample.bean.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/Login.html", method = RequestMethod.GET)
	public ModelAndView getRegForm() {

		return new ModelAndView("Login", "command", new User());
	}

	@RequestMapping(value = "/StartPage.html", method = RequestMethod.GET)
	public String getStartPage() {

		return "StartPage";
	}

	@RequestMapping(value = "/authentication.html", method = RequestMethod.POST)
	public String authCheck(@ModelAttribute("login") User user,
			HttpSession session) {

		if (user.getName().equals("admin") && user.getId().equals("123456")) {
			session.setAttribute("USERNAME", "Autherised user");
			// return new ModelAndView("redirect:/authUser/registration.html");
			return "Success";
		} else {
			// return new ModelAndView("redirect:/Login.html");
			session.setAttribute("USERNAME", null);
			return "Failure";
		}
	}

}

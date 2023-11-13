package dev.spring.exam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello 요청");
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public String hello2(Model model) {
		System.out.println("hello 요청");
		model.addAttribute("name", "김김김");
		return "hello2";
	}
	
	@RequestMapping("/hello3")
	public String hello3(HttpServletRequest req) {
		System.out.println("hello 요청");
		req.setAttribute("name", "김김김");
		return "hello2";
	}

}

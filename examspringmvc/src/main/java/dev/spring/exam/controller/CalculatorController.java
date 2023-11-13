package dev.spring.exam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
	
	@RequestMapping("/add1")
	public String add1(HttpServletRequest req, Model model) {
		
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		
		int result = n1 + n2;
		
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("result", result);

		return "add";
	}
	
	@RequestMapping("/add2")
	public String add2(Model model, int n1, int n2) {
		
		int result = n1 + n2;
		
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("result", result);

		return "add";
	}
	
	@RequestMapping("/add3")
	public String add3(Model model, int n1, @RequestParam(name = "n2") int n) {
		
		int result = n1 + n;
		
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n);
		model.addAttribute("result", result);

		return "add";
	}
	
	@RequestMapping("/add4")
	public String add4(Model model, int n1, Data data) {	// 커맨드 객체
		
		int result = data.getN1() + data.getN2();
		
		model.addAttribute("n1", data.getN1());
		model.addAttribute("n2", data.getN2());
		model.addAttribute("result", result);

		return "add";
	}
}

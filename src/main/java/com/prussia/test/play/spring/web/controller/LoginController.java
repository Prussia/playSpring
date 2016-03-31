package com.prussia.test.play.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Scope("request")
@RestController
@RequestMapping("/api")
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Map<?,?> loginPage(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		Map<String,String> params = new HashMap<String,String>();
        params.put("username1", username);
        params.put("password2", password);
		return params;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Map<String,String> map, HttpSession session) {
//		decrypt the password
		
//		model.addAttribute("param.logout", false);
//		model.addAttribute("username", username);
//		if(!username.equals("username") || !password.equals("password")){
//			model.addAttribute("param.error", true);
//			return "login";
//		}
//		
//		username = "Prussia";
//		
//		session.setAttribute("username", username);
		
//		return "home";
		//return "redirect:home.html";
		return "I am post login : " + map.get("username");
	}
	
//	public String greetingTp(@RequestParam(value = "username", required = true) String username,
//			@RequestParam(value = "password", required = true) String password, Model model, HttpSession session) {

}

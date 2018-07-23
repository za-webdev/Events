package com.zoya.EventsProject.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.zoya.EventsProject.models.User;
import com.zoya.EventsProject.services.MyEventService;
import com.zoya.EventsProject.services.UserService;
import com.zoya.EventsProject.validators.UserValidator;


@Controller
public class Users {
	
	private UserValidator userValidator;
	private UserService userService;
	private MyEventService eService;
	
	
	public Users(UserValidator userValidator,UserService userService,MyEventService eService) {
		this.userValidator=userValidator;
		this.userService=userService;
		this.eService=eService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "welcome";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam Map <String,String> body,RedirectAttributes flash,HttpSession session) {
		HashMap<String,Object> results = userValidator.register(body);
		if((boolean) results.get("valid")) {
			session.setAttribute("user", userService.create(body));
		}
		else {
			flash.addFlashAttribute("errors", results);
			return "redirect:/";
		}
		
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map <String,String> body,RedirectAttributes flash,HttpSession session) {
		User user = userValidator.login(body);
		if(user !=null){
			session.setAttribute("user", user);
			flash.addFlashAttribute("msg",String.format("welcome back: %s!",user.getFirstName()));
		}
		else {
			flash.addFlashAttribute("loginErr","Invalid credentials");
			return "redirect:/";
		}
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}


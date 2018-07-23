package com.zoya.EventsProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoya.EventsProject.models.Message;
import com.zoya.EventsProject.models.MyEvent;
import com.zoya.EventsProject.models.User;
import com.zoya.EventsProject.services.MessageService;
import com.zoya.EventsProject.services.MyEventService;
import com.zoya.EventsProject.services.UserService;

@Controller
public class MyEvents {
	private MyEventService eService;
	private MessageService msgService;
	private UserService userService;
	
	public MyEvents( MyEventService eService,MessageService msgService,UserService userService) {
		this.eService=eService;
		this.msgService=msgService;
		this.userService=userService;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("event", new MyEvent());
		model.addAttribute("allEvents",eService.findAll());
		return "dashboard";
	}
	
	@PostMapping("/new/event")
	public String myEvent(@Valid @ModelAttribute("event") MyEvent myEvent, BindingResult result,Model model ) {
		if(result.hasErrors()) {
			model.addAttribute("allEvents",eService.findAll());
			return "dashboard";
		}
		eService.create(myEvent);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/edit/{id}")
	public String editEvent(Model model, @PathVariable("id") Long id) {
		model.addAttribute("event", eService.findOne(id));
		return "edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateEvnt(@Valid @ModelAttribute("event") MyEvent myEvent, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit";
		} 
		
		eService.update(myEvent);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        eService.destroy(id);
        return "redirect:/dasboard";
    }
	
	@RequestMapping("/show/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		model.addAttribute("message", new Message());
		model.addAttribute("event", eService.findOne(id));
		return "show";
	}
	
	@PostMapping("/msg/{id}")
	public String addMessage(@Valid @ModelAttribute("message") Message message, BindingResult result, @PathVariable("id") Long id,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("event", eService.findOne(id));
		}
		
		message.setId(null);
		
		msgService.create(message);
		return "redirect:/show/"+id;
	}
	
	@RequestMapping("/join")
	public String joinEvent(@RequestParam Long user_id,@RequestParam Long event_id) {
		
		User user = userService.findOne(user_id);
		MyEvent event = eService.findOne(event_id);
		List<MyEvent> joinedEvents =user.getJoinedEvents();
		joinedEvents.add(event);
		user.setJoinedEvents(joinedEvents);
		userService.update(user);
		
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/admin/info")
	public String adminPage(HttpSession session,Model model) {
		User user= (User) session.getAttribute("user");
		if(user.getAdminLevel().equals("admin")) {
			
			model.addAttribute("allUsers",userService.findAll());
			return "admin";
		}
		return "redirect:/dashboard";
	}	
	
}

package com.securityex.SecurityDemo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.securityex.SecurityDemo.dao.UsersRepository;

@Controller
public class HomeConteoller {
	
	@Autowired
	UsersRepository uP;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/secured")
	public ModelAndView secured() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/nonadmin")
	public ModelAndView index1() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	
	@RequestMapping("/courselist")
	public ModelAndView courselist() {
		ModelAndView mv = new ModelAndView();
		List<Course> courses = new ArrayList<>();
		courses = uP.findAll();
		return mv.addObject("courselist", courses);
	}
	
	@RequestMapping("/enrollment")
	public ModelAndView update(@RequestParam("courseid") Course courseid) {
	
		return new ModelAndView("enrollment", "courseid", courseid);
	}
}

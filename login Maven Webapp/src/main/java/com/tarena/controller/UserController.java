package com.tarena.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.bean.User;
import com.tarena.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String login(User user,Map map){
		user=userService.login(user);
		if(user!=null){
			map.put("msg", "登陆成功");
			return "/jsps/index";
		}else{
			map.put("msg", "登陆失败");
			return "/jsps/error";
		}
	}
	@RequestMapping("/showUser")
	 public String toIndex(HttpServletRequest request,Model model){
	    int userId = Integer.parseInt(request.getParameter("id"));
	    User user = this.userService.getUserById(userId);
	    model.addAttribute("user", user);
	    return "showUser";
	 }
	 
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}

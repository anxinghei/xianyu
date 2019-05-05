package com.how2java.tmall.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Exam;
import com.how2java.tmall.pojo.Subject;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.ExamService;
import com.how2java.tmall.service.SubjectService;
import com.how2java.tmall.service.UserService;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	ExamService examService;

// 用户登录	
	@RequestMapping("/tologin.action")
	public String tologin() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(User user, HttpSession session,HttpServletResponse response) {
		List<User> users = userService.findByName(user.getName());
		String password = user.getPassword();
		if (!users.isEmpty()) {
			// 用户名正确
			String realPassword = users.get(0).getPassword();
			if (password.equals(realPassword)) {
				// 密码正确 -> 登录成功
				session.setAttribute("USER_SESSION", users.get(0));
				Cookie cookie=new Cookie("user", users.get(0).getId()+"-"+user.getName());
				cookie.setMaxAge(3*24*60*60);
				response.addCookie(cookie);
				return "main";
			} else {
				// 密码错误 -> 登录失败
				session.setAttribute("msg", "用户名或密码错误，请重新登录！");
				return "login";
			}
		}
		// 用户名错误
		session.setAttribute("msg", "用户名或密码错误，请重新登录！");
		return "login";
	}

// 退出登录		
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("msg", "");
		return "login";
	}

// 用户注册	
	@RequestMapping(value = "/toregister", method = RequestMethod.GET)
	public String toregister(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int num) {
		PageHelper.startPage(num, 5);
		List<Subject> subjects = subjectService.list();
		model.addAttribute("subs", subjects);
		PageInfo<Subject> pageInfo = new PageInfo<Subject>(subjects);
		model.addAttribute("page", pageInfo);
		return "register";
	}

	@RequestMapping("/register")
	public String register(User user, Model model) {
		String username = user.getName();
		if (!username.isEmpty() && !user.getPassword().isEmpty() && user.getSubid() != null) {
			List<User> users = userService.findByName(username);
			if (!users.isEmpty()) {
				model.addAttribute("zhuce", "用户名已存在，请重新注册！");
				return "register";
			} else
				userService.addUser(user);
			return "redirect:tologin";
		} else {
			model.addAttribute("zhuce", "注册信息为空，请重新注册！");
			return "register";
		}
	}

// 返回主菜单	
	@RequestMapping("/home")
	public String home() {
		return "main";
	}

// 查看个人信息	
	@RequestMapping("/touser")
	public String touser(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int num) {
		User user=(User)session.getAttribute("USER_SESSION");
		PageHelper.startPage(num, 5);
		List<Exam> exams=examService.list(user.getId());
		session.setAttribute("exams", exams);
		PageInfo<Exam> pageInfo = new PageInfo<Exam>(exams);
		session.setAttribute("page", pageInfo);
		return "user";
	}
}

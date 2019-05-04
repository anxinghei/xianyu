package com.how2java.tmall.controller;

import java.util.List;

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

// �û���¼	
	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(User user, HttpSession session) {
		List<User> users = userService.findByName(user.getName());
		String password = user.getPassword();
		if (!users.isEmpty()) {
			// �û�����ȷ
			String realPassword = users.get(0).getPassword();
			if (password.equals(realPassword)) {
				// ������ȷ -> ��¼�ɹ�
				session.setAttribute("USER_SESSION", users.get(0));
				return "main";
			} else {
				// ������� -> ��¼ʧ��
				session.setAttribute("msg", "�û�����������������µ�¼��");
				return "login";
			}
		}
		// �û�������
		session.setAttribute("msg", "�û�����������������µ�¼��");
		return "login";
	}

// �˳���¼		
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("msg", "");
		return "redirect:tologin";
	}

// �û�ע��	
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
				model.addAttribute("zhuce", "�û����Ѵ��ڣ�������ע�ᣡ");
				return "register";
			} else
				userService.addUser(user);
			return "redirect:tologin";
		} else {
			model.addAttribute("zhuce", "ע����ϢΪ�գ�������ע�ᣡ");
			return "register";
		}
	}

// �������˵�	
	@RequestMapping("/home")
	public String home() {
		return "main";
	}

// �鿴������Ϣ	
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

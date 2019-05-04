package com.how2java.tmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.tmall.pojo.Question;
import com.how2java.tmall.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@RequestMapping("queslist")
	public String questionList(short catid,HttpSession session) {
		List<Question> questions=questionService.list(catid);
		session.setAttribute("questions", questions);
		return "listquestion";
	}
}

package com.how2java.tmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.tmall.pojo.Exam;
import com.how2java.tmall.pojo.Examitems;
import com.how2java.tmall.pojo.Question;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.ExamService;
import com.how2java.tmall.service.ExamitemsService;
import com.how2java.tmall.service.QuestionService;

@Controller
public class ExamController {

	@Autowired
	ExamService examService;
	@Autowired
	QuestionService questionService;
	@Autowired
	ExamitemsService examitemsService;
	
	@RequestMapping("addtoexam")
	public String add(HttpSession session,String[] ids,String examname) {
		User user =(User )session.getAttribute("USER_SESSION");
		Exam exam=new Exam();
		exam.setName(examname);
		exam.setUserid(user.getId());
		List<Question> questions=(List<Question>) session.getAttribute("questions");
		exam.setCatid(questions.get(0).getCatid());
		examService.add(exam);		
		Exam exam2=examService.findByName(examname);
		int id=0;
		Question question=null;
		Examitems examitems=new Examitems();
		for(String string :ids){
			id=Integer.valueOf(string);
			question=questionService.findById(id);
			examitems.setContent(question.getContent());
			examitems.setExamid(exam2.getId());
			examitemsService.add(examitems);
		}
		return "redirect:touser";
	}
}

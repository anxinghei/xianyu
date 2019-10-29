package com.how2java.tmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.how2java.tmall.interator.DocumentHandler;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Exam;
import com.how2java.tmall.pojo.Examitems;
import com.how2java.tmall.pojo.Question;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.CategoryService;
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
	@Autowired
	CategoryService CategoryService;

	@RequestMapping("addtoexam")
	public String add(HttpSession session, String[] ids, String examname) {
		User user = (User) session.getAttribute("USER_SESSION");
		Exam exam = new Exam();
		exam.setName(examname);
		exam.setUserid(user.getId());
		List<Question> questions = (List<Question>) session.getAttribute("questions");
		exam.setCatid(questions.get(0).getCatid());
		examService.add(exam);
		Exam exam2 = examService.findByName(examname);
		int id = 0;
		Question question = null;
		Examitems examitems = new Examitems();
		for (String string : ids) {
			id = Integer.valueOf(string);
			question = questionService.findById(id);
			examitems.setContent(question.getContent());
			examitems.setExamid(exam2.getId());
			examitemsService.add(examitems);
		}
		return "redirect:touser";
	}

	@RequestMapping(value="/exportWord/{id}")
	@ResponseBody
	public void exportWordTest(@PathVariable("id")int id,HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("使用freemark导出Word");
		Map<String, Object> map = new HashMap<>();
		Exam exam=examService.findById(id);
		Category category=CategoryService.findById(exam.getCatid());
		map.put("category", category.getName());
		List<Examitems> items=examitemsService.list(id);
		String idString="";
		String contentString="";
		int num=0;
		if (items.size()>=24) {
			for (int i = 0; i <24; i++) {
				num=i+1;
				idString="id"+num;
				contentString="content"+num;
				map.put(idString, num);
				map.put(contentString, items.get(i).getContent());
			}
		}else {
			for (int i = 0; i < items.size(); i++) {
				num=i+1;
				idString="id"+num;
				contentString="content"+num;
				map.put(idString, num);
				map.put(contentString, items.get(i).getContent());
			}
			for (int i = items.size(); i <24; i++) {
				num=i+1;
				idString="id"+num;
				contentString="content"+num;
				map.put(idString, " ");
				map.put(contentString," ");
			}
		}
		System.out.println(map);
		boolean b = new DocumentHandler().exportDoc("temp", exam.getName(), map, resp);
		System.out.println(b);
	}

}

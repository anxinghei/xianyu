package com.how2java.tmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Exam;
import com.how2java.tmall.pojo.Examitems;
import com.how2java.tmall.service.ExamitemsService;

@Controller
public class ExamitemsController {

	@Autowired
	ExamitemsService examitemsService;
	
	@RequestMapping("examitemsList")
	public String examitemsList(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int num,
			@RequestParam(value = "examid")int examid) {
		PageHelper.startPage(num, 2);
		List<Examitems> examitems=examitemsService.list(examid); 
		session.setAttribute("examitems", examitems);
		PageInfo<Examitems> pageInfo = new PageInfo<Examitems>(examitems);
		session.setAttribute("page", pageInfo);
		return "lists/listExamitems_exam";
	}
}

package com.how2java.tmall.interator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.tmall.pojo.User;

public class LoginInterator implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies=request.getCookies();
		Boolean iscook=false;
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				// ����user
				if("user".equals(cookie.getName())) {
					// ���õ�¼�û�
					HttpSession session=request.getSession();
					String string=cookie.getValue();
					String[] strings=string.split("-");
					User user=new User();
					user.setId(Integer.valueOf(strings[0]));
					user.setName(strings[1]);
					user.setSubid(Short.valueOf(strings[2]));
					session.setAttribute("USER_SESSION", user);
					// �ض���
					response.sendRedirect("/exam/home");
					iscook=true;
				}
			}
			// ����Cookies����û��"user"
			if(iscook==false)
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "����û�е�¼�����ȵ�¼��");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
//		String url=request.getRequestURI();
//		if(url.indexOf("/login")>=0)
//			return true;
//		HttpSession session=request.getSession();
//		User user=(User)session.getAttribute("USER_SESSION");
//		if(user!=null)
//			return true;
//		request.setAttribute("msg", "����û�е�¼�����ȵ�¼��");
//		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

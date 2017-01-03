package edu.zime.wzd.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		//如果是登录页面则放行
		if(request.getRequestURI().indexOf("login")>=0){
			return true;
		}
		HttpSession session = request.getSession();
		//如果用户已登录也放行
		if(session.getAttribute("user")!=null){
			return true;
		}
		//用户没有登录挑战到登录页面
		request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
		
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
}

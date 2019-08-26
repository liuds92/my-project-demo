package com.liuds.core.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class Token interceptor.
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {


	private static final String OPTIONS = "OPTIONS";
	private static final String AUTH_PATH1 = "/auth";
	private static final String AUTH_PATH2 = "/oauth";
	private static final String AUTH_PATH3 = "/error";
	private static final String AUTH_PATH4 = "/api";

	/**
	 * After completion.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param arg2     the arg 2
	 * @param ex       the ex
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception ex) throws Exception {
		if (ex != null) {
			log.error("<== afterCompletion - 解析token失败. ex={}", ex.getMessage(), ex);
			this.handleException(response);
		}
	}

	/**
	 * Post handle.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param arg2     the arg 2
	 * @param mv       the mv
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mv) {
	}

	/**
	 * Pre handle boolean.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param handler  the handler
	 *
	 * @return the boolean
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String uri = request.getRequestURI();
		log.info("<== preHandle - 权限拦截器.  url={}", uri);
		if (uri.contains(AUTH_PATH1) || uri.contains(AUTH_PATH2) || uri.contains(AUTH_PATH3) || uri.contains(AUTH_PATH4)) {
			log.info("<== preHandle - 配置URL不走认证.  url={}", uri);
			return true;
		}
		log.info("<== preHandle - 调试模式不走认证.  OPTIONS={}", request.getMethod().toUpperCase());

		if (OPTIONS.equalsIgnoreCase(request.getMethod())) {
			log.info("<== preHandle - 调试模式不走认证.  url={}", uri);
			return true;
		}


		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		log.info("<== preHandle - 权限拦截器.  token={}", token);
		log.info("uid={}", request.getHeader("UID"));

		return true;
	}

	private void handleException(HttpServletResponse res) throws IOException {
		res.resetBuffer();
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write("{\"code\":100009 ,\"message\" :\"解析token失败\"}");
		res.flushBuffer();
	}

}
  
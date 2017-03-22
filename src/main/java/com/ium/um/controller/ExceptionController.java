package com.ium.um.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController implements ErrorController{

	private static ExceptionController exceptionController;
	private final static String ERROR_PATH = "/error/error.html";
	
	@Autowired
	private ErrorAttributes errorAttributes;
	
	public ExceptionController(){
		
		if( exceptionController == null){
			exceptionController = new ExceptionController(errorAttributes);
		}
	}
	
	public ExceptionController( ErrorAttributes errAttributess){
		
		this.errorAttributes = errorAttributes;
	}
	
	@Override
	public String getErrorPath() {
		
		return ERROR_PATH;
	}
	
	/**
	 * 返回Trace信息
	 * @param request
	 * @return
	 */
	private boolean getTraceParameter( HttpServletRequest request){
		
		String parameter = request.getParameter("trace");
		if(parameter == null){
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}
	
	/**
	 * 返回具体的错误信息
	 * @param request
	 * @param includeStackTrace
	 * @return
	 */
	private Map<String, Object> getErrorAttributes( HttpServletRequest request, boolean includeStackTrace){
		
		RequestAttributes requestArrtibutes = new ServletRequestAttributes(request);
		Map<String, Object> map = this.errorAttributes.getErrorAttributes(requestArrtibutes, includeStackTrace);
		String url = request.getRequestURL().toString();
		map.put("url", url);
		//logger.debug("ExceptionController.method [error info]: status " + map.get("status") + ", request url= " + url);
		return map;
	}

	
	private HttpStatus getStstus( HttpServletRequest request){
		
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if( statusCode != null){
			return HttpStatus.valueOf(statusCode);
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	/**
	 * 返回HTML的错误页面
	 * @param request
	 * @return
	 */
	@RequestMapping( value = ERROR_PATH, produces = "text/html")
	public ModelAndView errorHtml( HttpServletRequest request){
		
		//System.out.println(getErrorAttributes(request, false));
		return new ModelAndView("error", getErrorAttributes(request, false));
	}
	
	/**
	 * 返回JSON/XML的错误页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ERROR_PATH)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request){
		
		Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
		HttpStatus status = getStstus(request);
		
		return new ResponseEntity<Map<String, Object>>(body, status);
	}
	 
}

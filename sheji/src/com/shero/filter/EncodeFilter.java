package com.shero.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebFilter(
	description = "�ַ����������", 
	filterName = "encodingFilter", 
	urlPatterns = { "/*" },
	initParams = { 
		@WebInitParam(name = "ENCODING", value = "UTF-8")
	} 
)
public class EncodeFilter implements Filter {

	private static Logger log = Logger.getLogger("EncodingFilter");
	private String encoding="";
	private String filterName="";

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		log.debug("����"+filterName+"����");
		if("GET".equals(request.getMethod())){
			request = new RequestEncodingWrapper(request,encoding);
		}else{
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);
		//�����������������
		chain.doFilter(request, response);
		log.debug("��Ӧ��"+filterName+"����");

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//ͨ��filterConfig��ó�ʼ���б���ֵ
		encoding = filterConfig.getInitParameter("ENCODING");
		filterName = filterConfig.getFilterName();
		if(encoding==null||"".equals(encoding)){
			encoding="UTF-8";
		}
		log.debug("��ñ���ֵ");
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		log.debug("��������");
	}
}


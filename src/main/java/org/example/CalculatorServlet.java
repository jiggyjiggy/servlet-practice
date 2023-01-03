package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.vo.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {
	private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		log.info("init");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		log.info("service");
		int operand1 = Integer.parseInt(request.getParameter("operand1"));
		String operator = request.getParameter("operator");
		int operand2 = Integer.parseInt(request.getParameter("operand2"));
		
		Calculator calculator = new Calculator();
		int result = calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
		
		PrintWriter writer = response.getWriter();
		writer.println(result);
	}
	
	@Override
	public void destroy() {
	
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	
	@Override
	public String getServletInfo() {
		return null;
	}
}

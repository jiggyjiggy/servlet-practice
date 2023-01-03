package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.vo.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends GenericServlet {
	private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
	
	/**
	 * GenericServlet 상속시 service만 구현하면 된다.
	 */
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
}

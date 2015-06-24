package com.programcreek.helloworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.programcreek.helloworld.service.EmployeeManager;

public class EmployeeController implements Controller{
	EmployeeManager employeeManager;
	public EmployeeManager getEmployeeManager() {
		return employeeManager;
	}
	
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager =employeeManager;
	}
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView("employeeList");
		mv.addObject("empList", this.employeeManager.getEmployeeList());
		return mv;
	}

}

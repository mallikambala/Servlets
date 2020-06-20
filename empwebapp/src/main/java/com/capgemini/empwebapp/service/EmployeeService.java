package com.capgemini.empwebapp.service;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeInfoBean;

public interface EmployeeService {

	EmployeeInfoBean getEmployeeDetailsByname(String name);

	boolean deleteEmployeeInfo(int id);

	boolean updateEmployeeInfo(EmployeeInfoBean bean);

	boolean createEmployeeInfo(EmployeeInfoBean bean);

	List<EmployeeInfoBean> getAllEmployeeDetails();

	boolean addEmployeeInfo(EmployeeInfoBean bean);

}

package com.capgemini.empwebapp.service;

import java.util.List;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeDAOImpl;
import com.capgemini.empwebapp.dto.EmployeeInfoBean;

public class EmployeeServiceImpl  implements EmployeeService{

	
	private EmployeeDAO dao=new EmployeeDAOImpl();

	@Override
	public EmployeeInfoBean getEmployeeDetailsByname(String name) {
		// TODO Auto-generated method stub
		return dao.getEmployeeDetailsByname(name);
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployeeInfo(id);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return dao.updateEmployeeInfo(bean);
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return dao.createEmployeeInfo(bean);
	}

	@Override
	public boolean addEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return dao.addEmployeeInfo(bean);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return dao.getAllEmployeeDetails();
	}

}

package com.capgemini.empwebapp.dao;


import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeInfoBean;


public interface EmployeeDAO {
  public EmployeeInfoBean getEmployeeDetailsByname(String name);
  public boolean deleteEmployeeInfo(int id);
  public boolean updateEmployeeInfo(EmployeeInfoBean bean);
  public boolean createEmployeeInfo(EmployeeInfoBean bean);
  public boolean addEmployeeInfo(EmployeeInfoBean bean);
  public List<EmployeeInfoBean> getAllEmployeeDetails();
}
package com.capgemini.empwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeInfoBean;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public EmployeeInfoBean getEmployeeDetailsByname(String name) {
		ResultSet res = null;
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "select * from employee_info where name=?";
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");

			preparedStatement.setString(1, name);
			res = preparedStatement.executeQuery();
			EmployeeInfoBean beans = new EmployeeInfoBean();
			if (res.next()) {
				beans.setEid(res.getInt("eid"));
				beans.setName(res.getString("name"));
				beans.setEmailId(res.getString("email"));
				beans.setMobilenono(res.getLong("mobilenono"));
				beans.setGender(res.getString("gender"));
				return beans;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (res != null) {
					res.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return null;
	}


	@Override
	public boolean deleteEmployeeInfo(int id) {
		// TODO Auto-generated method stub
				String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
				String query = "delete from employee_info where eid=?";

				try (Connection connection = DriverManager.getConnection(url);
						PreparedStatement preparedStatement = connection.prepareStatement(query);) {
					Class.forName("com.mysql.jdbc.Driver");
					preparedStatement.setInt(1, id);
					int res = preparedStatement.executeUpdate();
					if (res != 0) {
						return true;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		String query = "update employee_info set name=? where eid=?";
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setString(1, bean.getName());
			preparedStatement.setInt(2, bean.getEid());
			int res = preparedStatement.executeUpdate();
			if (res != 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "insert into employee_info values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = DriverManager.getConnection(url);
				
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, bean.getEid());
			preparedStatement.setString(2, bean.getName());
			preparedStatement.setString(4, bean.getEmailId());
			preparedStatement.setLong(3, bean.getMobilenono());
			preparedStatement.setString(5, bean.getGender());
			preparedStatement.setInt(6, bean.getAge());
			preparedStatement.setLong(7, bean.getDob());
			preparedStatement.setString(8, bean.getDesignation());
			preparedStatement.setLong(9, bean.getSalary());
			preparedStatement.setLong(10, bean.getDeptid());
			preparedStatement.setLong(11, bean.getDoj());
			preparedStatement.setString(12, bean.getBloodgroup());

			

			int res = preparedStatement.executeUpdate();

			if (res != 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployeeDetails() {
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "select * from employee_info ";

		List<EmployeeInfoBean> info = new LinkedList<EmployeeInfoBean>();
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet res = preparedStatement.executeQuery();) {
			Class.forName("com.mysql.jdbc.Driver");
			while (res.next()) {
				EmployeeInfoBean beans = new EmployeeInfoBean();

				beans.setEid(res.getInt("eid"));
				beans.setName(res.getString("name"));
				beans.setEmailId(res.getString("email"));
				beans.setMobilenono(res.getLong("mobilenono"));
				beans.setGender(res.getString("gender"));
				beans.setAge(res.getInt("age"));
				beans.setDeptid(res.getInt("deptid"));
				beans.setDesignation(res.getString("designation"));
				beans.setDoj(res.getLong("doj"));
				beans.setDob(res.getLong("dob"));
				beans.setBloodgroup(res.getString("bloodgroup"));
				beans.setSalary(res.getLong("salary"));
				info.add(beans);
			}

			if (info.isEmpty()) {
				return null;
			} else {
				return info;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}


	@Override
	public boolean addEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
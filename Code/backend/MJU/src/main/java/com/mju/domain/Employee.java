package com.mju.domain;

// emp_id dept_id emp_name emp_rrn emp_edu emp_email PASS
public class Employee {
	private int empId;
	private int deptId;
	private String empName;
	private String empRrn;
	private String empEdu;
	private String empEmail;
	private String Pass;
	
	public Employee() {}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpRrn() {
		return empRrn;
	}
	public void setEmpRrn(String empRrn) {
		this.empRrn = empRrn;
	}
	public String getEmpEdu() {
		return empEdu;
	}
	public void setEmpEdu(String empEdu) {
		this.empEdu = empEdu;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", deptId=" + deptId + ", empName=" + empName + ", empRrn=" + empRrn
				+ ", empEdu=" + empEdu + ", empEmail=" + empEmail + ", Pass=" + Pass + "]";
	}
}

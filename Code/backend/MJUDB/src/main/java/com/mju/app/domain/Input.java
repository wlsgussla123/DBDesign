package com.mju.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Input {
	int empId;
	int prjId;
	Date empStartDate;
	Date empEndDate;
	int roleId;
}

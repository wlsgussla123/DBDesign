package com.mju.app.domain;

import lombok.Data;

@Data
public class Evaluation {
	private int evalId;
	private int subject; // 피평가자
	private int prjId;
	private int evalCategory;
	private int evaluator; // 평가자
	
	private int commGrade; // 커뮤니케이션 점수
	private String commContents; // 커뮤니케이션 평가 내용
	private int perfGrade; // 퍼모먼스 점수
	private String perfContents; // 퍼포먼스 평가 내용
	
	// 정보 객체들
	Employee subjectObj; // 피평가자 객체
	Project projectObj; // 프로젝트 객체
	Employee evalEmpObj; // 평가자 객체 (PM이나, 동료일 경우)
	Customer evalCusObj; // 평가자 객체 (손님일 경우)
}

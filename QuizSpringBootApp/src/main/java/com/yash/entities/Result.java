package com.yash.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Result {
	
	private int resultId;
	private int quizId;
	private int userId;
	private int marks;
	private int percentages;
	private int quizStatus;
	private LocalDate createTime;
	
	
	public Result() {}

	public Result(int resultId, int quizId, int userId, int marks, int percentages, int quizStatus) {
		super();
		this.resultId = resultId;
		this.quizId = quizId;
		this.userId = userId;
		this.marks = marks;
		this.percentages = percentages;
		this.quizStatus = quizStatus;
	}

	public int getResultId() {
		return resultId;
	}

	public int getQuizId() {
		return quizId;
	}

	public int getUserId() {
		return userId;
	}

	public int getMarks() {
		return marks;
	}

	public int getPercentages() {
		return percentages;
	}

	public int getQuizStatus() {
		return quizStatus;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setPercentages(int percentages) {
		this.percentages = percentages;
	}

	public void setQuizStatus(int quizStatus) {
		this.quizStatus = quizStatus;
	}
    
	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createTime, marks, percentages, quizId, quizStatus, resultId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		return Objects.equals(createTime, other.createTime) && marks == other.marks && percentages == other.percentages
				&& quizId == other.quizId && quizStatus == other.quizStatus && resultId == other.resultId
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", quizId=" + quizId + ", userId=" + userId + ", marks=" + marks
				+ ", percentages=" + percentages + ", quizStatus=" + quizStatus + ", createTime=" + createTime + "]";
	}

	
	
	

}

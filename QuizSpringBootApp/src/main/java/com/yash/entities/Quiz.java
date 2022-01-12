package com.yash.entities;

public class Quiz {
	
	private int quizId;
	private String quizName;
	private String quizLevel;
	private int userId;
	
	public Quiz() {};
	
	public Quiz(int quizId, String quizName, String quizLevel, int userId) {
		super();
		this.quizId = quizId;
		this.quizName = quizName;
		this.quizLevel = quizLevel;
		this.userId = userId;
	}
	public int getQuizId() {
		return quizId;
	}
	public String getQuizName() {
		return quizName;
	}
	public String getQuizLevel() {
		return quizLevel;
	}
	public int getUserId() {
		return userId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public void setQuizLevel(String quizLevel) {
		this.quizLevel = quizLevel;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quizId;
		result = prime * result + ((quizLevel == null) ? 0 : quizLevel.hashCode());
		result = prime * result + ((quizName == null) ? 0 : quizName.hashCode());
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (quizId != other.quizId)
			return false;
		if (quizLevel == null) {
			if (other.quizLevel != null)
				return false;
		} else if (!quizLevel.equals(other.quizLevel))
			return false;
		if (quizName == null) {
			if (other.quizName != null)
				return false;
		} else if (!quizName.equals(other.quizName))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizName=" + quizName + ", quizLevel=" + quizLevel + ", userId=" + userId
				+ ", getQuizId()=" + getQuizId() + ", getQuizName()=" + getQuizName() + ", getQuizLevel()="
				+ getQuizLevel() + ", getUserId()=" + getUserId() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	

}

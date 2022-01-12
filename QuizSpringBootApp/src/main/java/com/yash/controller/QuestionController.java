package com.yash.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.QuestionsResponse;
import com.yash.service.QuestionsServiceImplementation;

@RestController
@RequestMapping("questionapi")
@CrossOrigin(origins = "*")
public class QuestionController {
	
	@Autowired
	private QuestionsServiceImplementation serviceObj;
	
	@GetMapping("questions")
	public ResponseEntity<List<QuestionsResponse>> handleGetAllQuestionJSON(){
		List<QuestionsResponse> employeeResponseList=serviceObj.getQuestionsModel();
		ResponseEntity<List<QuestionsResponse>> response=null;
		if(!employeeResponseList.isEmpty()) {
		 response=new ResponseEntity<List<QuestionsResponse>>(employeeResponseList,HttpStatus.OK);
		}else {
			response=new ResponseEntity<List<QuestionsResponse>>(employeeResponseList,HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}
	@GetMapping("answers")
	public ResponseEntity<List<String>> handleGetAllAnswers()
	{
	
		List<QuestionsResponse>  answersResponseList = serviceObj.getAnswers();
		ResponseEntity<List<String>> response=null;
		List<String> answerList=new ArrayList<String>();
		for(QuestionsResponse questionResponse:answersResponseList) {
			
			String answer=questionResponse.getCorrectAnswer();
			answerList.add(answer);
		}
			 response=new ResponseEntity<List<String>>(answerList,HttpStatus.OK);		
			
			return response;
		}
	}


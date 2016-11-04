package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

	@RequestMapping(value="/post-question", method = RequestMethod.POST)
	public ResponseEntity<String> postQuestion(@RequestParam("question") String question){
		
		System.out.println("Question: " + question);
		
		return new ResponseEntity<String>(question, HttpStatus.OK);
	} 
	
}

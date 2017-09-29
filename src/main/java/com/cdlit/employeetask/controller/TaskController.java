package com.cdlit.employeetask.controller;

import com.cdlit.employeetask.model.*;
import com.cdlit.employeetask.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired TaskRepository taskRepository;
	
	//Get All Tasks
	@RequestMapping(method = RequestMethod.GET)
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	//Create a New Task
	/*  The @RequestBody annotation is used to bind the request body with a method parameter.

		The @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content with @NotBlank annotation in the Note model?

		If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client.
    * */

	@RequestMapping(method = RequestMethod.POST)
	public Task createTask(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	//Get a Single Task
	
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value = "id")Long taskId){
		Task task = taskRepository.findOne(taskId);
		
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(task);
	}
	
	
	//Update a Task
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long taskId, @Valid @RequestBody Task taskDetails){
		Task task = taskRepository.findOne(taskId);
		
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		
		task.setTaskName(taskDetails.getTaskName());
		task.setTaskDescription(taskDetails.getTaskDescription());
		
		Task updateTask = taskRepository.save(task);
		
		return ResponseEntity.ok(updateTask);
	}
	
	
	//Delete a Task
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Task> deleteNote(@PathVariable(value = "id") Long taskId){
		Task task = taskRepository.findOne(taskId);
		
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		
		taskRepository.delete(task);
		return ResponseEntity.ok().build();
	}
}

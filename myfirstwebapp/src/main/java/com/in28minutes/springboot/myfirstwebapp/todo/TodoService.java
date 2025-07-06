package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	static
	{
todos.add(new Todo(++todosCount,"in28minutes","Learn Spring",
		LocalDate.now().plusYears(3),false));
todos.add(new Todo(++todosCount,"in28minutes","Learn FullStack",
		LocalDate.now().plusYears(2),false));
todos.add(new Todo(++todosCount,"in28minutes","Learn Devops",
		LocalDate.now().plusYears(1),false));
todos.add(new Todo(++todosCount,"in28minutes","Learn Hacking",
		LocalDate.now().plusYears(5),false));
		
	}
	public List<Todo> findByUsername(String username)
	{
		Predicate<? super Todo> predicate= todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	public void addTodo(String username,String description,LocalDate target,boolean done)
	{
		Todo todo = new Todo(++todosCount,username,description,target,done);
		todos.add(todo);
		
	}
	public void deleteTodo(int id)
	{
		Predicate<? super Todo> predicate= todo -> todo.getId()==id;
		todos.removeIf(predicate);
		
	}
	public void updateTodo(int id)
	{
		Predicate<? super Todo> predicate= todo -> todo.getId()==id;
		todos.removeIf(predicate);
		
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate= todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
		
		
	}

}

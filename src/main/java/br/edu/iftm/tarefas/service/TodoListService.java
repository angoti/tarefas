package br.edu.iftm.tarefas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.tarefas.domain.TodoList;
import br.edu.iftm.tarefas.repository.TodoListRepository;

@Service
public class TodoListService {

	private TodoListRepository repository;

	public TodoListService(TodoListRepository repository) {
		super();
		this.repository = repository;
	}

	public List<TodoList> getAll() {
		List<TodoList> items = new ArrayList<TodoList>();
		repository.findAll().forEach(items::add);
		return items;
	}

	public TodoList getById(Long id) {
		Optional<TodoList> existingItemOptional = repository.findById(id);
		if (existingItemOptional.isPresent()) {
			return existingItemOptional.get();
		} else {
			return null;
		}
	}

	public TodoList create(TodoList item) {
		return repository.save(item);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}

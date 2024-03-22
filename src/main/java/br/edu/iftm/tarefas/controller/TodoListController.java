package br.edu.iftm.tarefas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tarefas.domain.TodoList;
import br.edu.iftm.tarefas.service.TodoListService;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "http://localhost:3000") // Permitir solicitações CORS deste domínio
public class TodoListController {

	TodoListService service;

	public TodoListController(TodoListService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<TodoList> getAll() {
		Logger.getLogger(TodoListController.class.getName()).info("Listando todas as tarefas");
		List<TodoList> tarefas = new ArrayList<TodoList>();
		service.getAll().forEach(tarefas::add);
		return tarefas;
	}

	@GetMapping("{id}")
	public TodoList getById(@PathVariable("id") Long id) {
		return service.getById(id);
	}

	@PostMapping
	public TodoList create(@RequestBody TodoList tarefa) {
		return service.create(tarefa);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}

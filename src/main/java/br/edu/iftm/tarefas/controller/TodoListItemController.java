package br.edu.iftm.tarefas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tarefas.domain.TodoListItem;
import br.edu.iftm.tarefas.service.TodoListItemService;

@RestController
@RequestMapping("/tarefa/{tarefaId}/item")
@CrossOrigin(origins = "http://localhost:3000") // Permitir solicitações CORS deste domínio
public class TodoListItemController {

	private TodoListItemService service;

	public TodoListItemController(TodoListItemService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<TodoListItem> getAll(@PathVariable("tarefaId") Long id) {
		return service.getAll(id);
	}

	@GetMapping("{id}")
	public TodoListItem getById(@PathVariable("id") Long idItem, @PathVariable("tarefaId") Long idTarefa) {
		return service.getById(idTarefa, idItem);
	}

	@PostMapping
	public TodoListItem create(@RequestBody TodoListItem item, @PathVariable("tarefaId") Long tarefaId) {
		return service.create(item, tarefaId);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}

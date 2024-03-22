package br.edu.iftm.tarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.tarefas.domain.TodoList;
import br.edu.iftm.tarefas.domain.TodoListItem;
import br.edu.iftm.tarefas.repository.TodoListItemRepository;
import br.edu.iftm.tarefas.repository.TodoListRepository;

@Service
public class TodoListItemService {

	private TodoListItemRepository repository;
	private TodoListRepository tarefaRepository;

	public TodoListItemService(TodoListItemRepository repository, TodoListRepository tarefaRepository) {
		super();
		this.repository = repository;
		this.tarefaRepository = tarefaRepository;
	}

	//buscar todos os itens de uma tarefa
	public List<TodoListItem> getAll(Long tarefaId) {
		TodoList tarefa = tarefaRepository.findById(tarefaId).get();
		return repository.findByTarefa(tarefa);
	}
	
	public TodoListItem getById(Long id) {
		Optional<TodoListItem> existingItemOptional = repository.findById(id);
		if (existingItemOptional.isPresent()) {
			return existingItemOptional.get();
		} else {
			return null;
		}
	}
	
	public TodoListItem create(TodoListItem item, Long tarefaId) {
		TodoList tarefa = tarefaRepository.findById(tarefaId).get();
		item.setTarefa(tarefa);
		return repository.save(item);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}

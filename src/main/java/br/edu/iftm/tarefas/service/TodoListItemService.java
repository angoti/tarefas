package br.edu.iftm.tarefas.service;

import java.util.ArrayList;
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

	// buscar todos os itens de uma tarefa
	public List<TodoListItem> getAll(Long tarefaId) {
		final List<TodoListItem> itens = new ArrayList<TodoListItem>();
		tarefaRepository.findById(tarefaId).ifPresent(tarefa -> {
			itens.addAll(repository.findByTarefa(tarefa));
		});
		return itens;
	}

	// buscar um item (especificado por idItem), de uma tarefa especificada por
	// idTarefa
	public TodoListItem getById(Long idTarefa, Long idItem) {
		// primeiro buscar a tarefa
		Optional<TodoList> tarefa = tarefaRepository.findById(idTarefa);
		if (tarefa.isPresent()) {
			// depois buscar o item
			Optional<TodoListItem> item = repository.findById(idItem);
			if (item.isPresent()) {
				// verificar se o item pertence à tarefa
				if (item.get().getTarefa().equals(tarefa.get())) {
					return item.get();
				}
			}
		}
		return null;
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

package br.edu.iftm.tarefas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tarefas.domain.TodoList;
import br.edu.iftm.tarefas.domain.TodoListItem;

@Repository
public interface TodoListItemRepository extends CrudRepository<TodoListItem, Long>{
	List<TodoListItem> findByTarefa(TodoList tarefa);
}

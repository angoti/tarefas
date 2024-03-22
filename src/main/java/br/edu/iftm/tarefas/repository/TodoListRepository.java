package br.edu.iftm.tarefas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tarefas.domain.TodoList;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long>{
	
}

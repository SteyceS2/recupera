package com.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.entities.Tarefa;
import com.tarefa.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
	
	private final TarefaService tarefaService;

	@Autowired
	public TarefaController(TarefaService tarefaService) {
	this.tarefaService = tarefaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscaTarefasControlId(@PathVariable Long id){
	Tarefa tarefa = tarefaService.buscaTarefaId(id);
	if(tarefa != null) {
	return ResponseEntity.ok(tarefa);
	}
	else {
	return ResponseEntity.notFound().build();
	}
	}
	@GetMapping("/")
	public ResponseEntity<List<Tarefa>> buscaTodosTarefaControl(){
	List<Tarefa> Tarefa = tarefaService.buscaTodosTarefas();
	return ResponseEntity.ok(Tarefa);
	}
	@PostMapping("/")
	public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody @Valid Tarefa tarefa){
	Tarefa salvaTarefa = tarefaService.salvatarefa(tarefa);
	return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
	}
	@PutMapping("/(id")
	public ResponseEntity<Tarefa> alterarTarefaControl(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
	Tarefa alterarTarefa = tarefaService.alterarTarefa(id, tarefa);
	if(alterarTarefa != null) {
	return ResponseEntity.ok(tarefa);
	}
	else {
	return ResponseEntity.notFound().build();
	}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Tarefa> apagarTarefaControl(@PathVariable Long id){
	boolean apagar = tarefaService.apagarTarefa(id);
	if(apagar) {
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	else {
	return ResponseEntity.notFound().build();
	}
	}
	}


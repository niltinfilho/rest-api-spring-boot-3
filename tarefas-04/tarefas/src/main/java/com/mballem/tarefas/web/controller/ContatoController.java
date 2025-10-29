package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("tarefas/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    // EXERCICIO 1
    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        Contato contact = contatoService.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    // EXERCICIO 2
    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        Contato contact = contatoService.getById(id);
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 3
    @GetMapping()
    public ResponseEntity<Contato> getContatoByNome(@RequestParam String nome) {
        Contato contact = contatoService.getContatoByNome(nome);
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 4
    @GetMapping("/count")
    public ResponseEntity<Integer> getQuantidadeDeContatos() {
        Integer contact = contatoService.getAll();
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 5
    public Object getContatosByDataNascimento() {

        return null;
    }

    // EXERCICIO 6
    public Object updateContatoById() {

        return null;
    }

    // EXERCICIO 7
    public Object deleteById() {

        return null;
    }
}

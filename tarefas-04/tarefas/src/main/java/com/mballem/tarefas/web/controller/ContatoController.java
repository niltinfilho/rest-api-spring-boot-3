package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    @GetMapping("/data/{data}")
    public ResponseEntity<List<Contato>> getContatosByDataNascimento(@PathVariable LocalDate data) {
        List<Contato> contacts = contatoService.getByDataNascimento(data);
        return ResponseEntity.ok(contacts);
    }

    // EXERCICIO 6
    @PatchMapping("/{id}")
    public ResponseEntity<Contato> updateContatoById(@PathVariable Long id, @RequestBody Contato contato) {
        Contato contatoAtualizado = contatoService.update(id, contato);
        return ResponseEntity.ok(contatoAtualizado);
    }

    // EXERCICIO 7
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String contato = contatoService.delete(id);
        return ResponseEntity.ok(contato);
    }
}

package br.com.rocha.rinha.backend.controllers;

import br.com.rocha.rinha.backend.models.Pessoa;
import br.com.rocha.rinha.backend.services.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequestMapping("/pessoas")
@RestController
@AllArgsConstructor
public class PessoaController {

    private PessoaService pessoaService;


    @GetMapping
    public Flux<Pessoa> getAll(@RequestParam(required = false, name = "t") String t) {
        return t != null && !t.isEmpty() ? pessoaService.buscarPessoas(t) : pessoaService.listaPessoas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pessoa> addPessoas(@Valid @RequestBody Pessoa pessoa) {
        return this.pessoaService.cadastraPessoa(pessoa);
    }

    @GetMapping("/{id}")
    public Mono<Pessoa> buscaPessoaPeloID(@PathVariable("id") String id){
        return pessoaService.buscaPessoaPeloID(id);
    }


}

package br.com.rocha.rinha.backend.services;

import br.com.rocha.rinha.backend.models.Exception.UsuarioJaRegistrado;
import br.com.rocha.rinha.backend.models.Exception.UsuarioNaoEncontrado;
import br.com.rocha.rinha.backend.models.Pessoa;
import br.com.rocha.rinha.backend.repositories.PessoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PessoaService {

    private PessoalRepository pessoalRepository;

    @Autowired
    public PessoaService(PessoalRepository pessoalRepository) {
        this.pessoalRepository = pessoalRepository;
    }

    public PessoaService() {
    }

    public Flux<Pessoa> listaPessoas() {
        return pessoalRepository.findAll();
    }

    public Mono<Pessoa> cadastraPessoa(Pessoa pessoa) {
        return pessoalRepository.findFirstByApelido(pessoa.getApelido())
                .flatMap(p ->
                        Mono
                                .error(new UsuarioJaRegistrado("Pessoa já cadastrado")))
                .then(pessoalRepository.save(pessoa));
    }

    public Mono<Pessoa> buscaPessoaPeloID(String id) {
        return pessoalRepository.findById(id).switchIfEmpty(
                Mono.error(new UsuarioNaoEncontrado("Pessoa não encontrada"))
        );
    }

}
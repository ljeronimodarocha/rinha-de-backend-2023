package br.com.rocha.rinha.backend.repositories;

import br.com.rocha.rinha.backend.models.Pessoa;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PessoalRepository extends ReactiveMongoRepository<Pessoa, String> {

    Mono<Pessoa> findFirstByApelido(String apelido);

}

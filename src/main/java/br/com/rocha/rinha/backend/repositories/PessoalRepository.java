package br.com.rocha.rinha.backend.repositories;

import br.com.rocha.rinha.backend.models.Pessoa;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PessoalRepository extends ReactiveMongoRepository<Pessoa, String> {

    Mono<Pessoa> findFirstByApelido(String apelido);

    @Query("{'$or': [" +
            "{'nome': {$regex: ?0, $options: 'i'}}, " +
            "{'apelido': {$regex: ?0, $options: 'i'}}, " +
            "{'stack': {$regex: ?0, $options: 'i'}}" +
            "]}")
    Flux<Pessoa> findByTermoDeBusca(String i);

}

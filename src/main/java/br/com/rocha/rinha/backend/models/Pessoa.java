package br.com.rocha.rinha.backend.models;

import br.com.rocha.rinha.backend.validators.string.StringOnly;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Document("pessoa")
@Data
public class Pessoa {

    @Id
    private String id;

    @Size(max = 32)
    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "Campo obrigatório")
    private String apelido;

    @Size(max = 100)
    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "Campo obrigatório")
    @StringOnly
    private String nome;

    private LocalDate nascimento;

    @StringOnly
    private List<String> stack;
}

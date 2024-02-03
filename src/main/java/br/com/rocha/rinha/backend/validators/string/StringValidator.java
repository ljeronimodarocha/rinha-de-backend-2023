package br.com.rocha.rinha.backend.validators.string;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.regex.Pattern;

public class StringValidator implements ConstraintValidator<StringOnly, Object> {

    private static final Pattern VALID_PATTERN = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+$");


    @Override
    public void initialize(StringOnly constraint) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // `@NotNull` deve ser usado para checar nulo
        }

        if (value instanceof String) {
            return !isNumeric((String) value);
        } else if (value instanceof Collection<?> collection) {
            return collection.stream().allMatch(item -> item instanceof String && !isNumeric((String) item));
        }

        return false; // Não é um tipo suportado
    }

    private boolean isNumeric(String str) {
        try {
            new BigDecimal(str);
            return true; // É um número
        } catch (NumberFormatException e) {
            return false; // Não é um número, é uma string
        }
    }

}

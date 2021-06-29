package br.com.zupacademy.diego.casadocodigo.validators;

import br.com.zupacademy.diego.casadocodigo.models.Categoria;
import br.com.zupacademy.diego.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NomeUnicoValidator implements ConstraintValidator<NomeUnico, Object> {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void initialize(NomeUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        String nome = (String) obj;
        List<Categoria> list = this.categoriaRepository.findByNome(nome);
        return list.isEmpty();
    }
}

package br.com.zupacademy.diego.casadocodigo.validators;

import br.com.zupacademy.diego.casadocodigo.dto.AutorFormDTO;
import br.com.zupacademy.diego.casadocodigo.models.Autor;
import br.com.zupacademy.diego.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, Object> {
    @Autowired
    AutorRepository autorRepository;

    @Override
    public void initialize(EmailUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        String email = (String) obj;
        List<Autor> list = this.autorRepository.findByEmail(email);
        return list.isEmpty();
    }
}

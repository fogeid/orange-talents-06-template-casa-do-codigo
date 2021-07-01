package br.com.zupacademy.diego.casadocodigo.validators;

import br.com.zupacademy.diego.casadocodigo.dto.EstadoFormDTO;
import br.com.zupacademy.diego.casadocodigo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoUnicoPorPaisValidator implements ConstraintValidator<EstadoUnicoPorPais, EstadoFormDTO> {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void initialize(EstadoUnicoPorPais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EstadoFormDTO dto, ConstraintValidatorContext context) {
        return estadoRepository.findByNomeAndPais_Id(dto.getNome(), dto.getPais()).isEmpty();
    }
}

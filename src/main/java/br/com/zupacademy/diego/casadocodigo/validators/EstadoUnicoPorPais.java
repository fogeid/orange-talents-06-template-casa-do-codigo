package br.com.zupacademy.diego.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EstadoUnicoPorPaisValidator.class)
public @interface EstadoUnicoPorPais {
    String message() default "Já existe um estado com essa nome para este país";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

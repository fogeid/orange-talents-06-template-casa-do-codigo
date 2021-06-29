package br.com.zupacademy.diego.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailUnicoValidator.class)
public @interface EmailUnico {
    String message() default "E-mail já cadastrado, tente outro e-mail.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";
}



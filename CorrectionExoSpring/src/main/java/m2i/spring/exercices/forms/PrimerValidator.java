package m2i.spring.exercices.forms;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.math3.primes.Primes;

public class PrimerValidator implements 
ConstraintValidator<IsPrime, Integer> {

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext cxt) {
      return value != null && Primes.isPrime(value);
  }
}

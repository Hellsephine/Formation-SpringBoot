package m2i.spring.exercices.annotations.exo1;

import java.lang.annotation.Annotation;

public class Exercice1 {

	public static void main(String[] args)
	{
		Class<?> clazz = AnnotatedClass.class;
		
		Annotation[] annotations = clazz.getAnnotations();
		
		for (Annotation annotation : annotations)
			System.out.println(annotation);
	}
}

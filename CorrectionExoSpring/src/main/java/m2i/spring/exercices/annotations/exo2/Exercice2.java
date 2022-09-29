package m2i.spring.exercices.annotations.exo2;

import java.lang.reflect.Method;

public class Exercice2 {

	public static void main(String[] args)
	{
		Class<?> clazz = AnnotatedClass.class;
		
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods)
			if (method.isAnnotationPresent(Exo2Annotation.class))
				System.out.println(method.getName());
			else
				System.out.println("Ignoré : " + method.getName());
	}
}

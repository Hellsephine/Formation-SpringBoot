package m2i.spring.exercices.annotations.exo2;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Class<?> clazz = SomeClass.class;
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods ) {
			if (method.isAnnotationPresent(Annotation.class)) {
				System.out.println("C'est bien annoté !"+" "+method);
			}
		}
	}
}
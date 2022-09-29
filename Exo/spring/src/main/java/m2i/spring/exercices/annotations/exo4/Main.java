package m2i.spring.exercices.annotations.exo4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		SomeClass someObject = new SomeClass();
		Method[] methods = someObject.getClass().getMethods();
		
		for (Method method : methods) {
			if (method.isAnnotationPresent(MethodAnnotation.class)) {
				method.invoke(someObject, "Bonjour");
			}
			
		}

	}

}

package m2i.spring.exercices.annotations.exo5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		SomeClass someObject = new SomeClass();
		Method[] methods = someObject.getClass().getMethods();
		
		
		for (Method method : methods) {
			Parameter[] methodP = method.getParameters();
			
			for (Parameter methodp : methodP) {
				if (method.isAnnotationPresent(MethodAnnotation.class)) {
					String m = (methodp.isAnnotationPresent(ParamAnnotation.class)) ? "With Annotation" : "Without Annotation";
					method.invoke(someObject, m);
				}
				}
			}	
		}
	}


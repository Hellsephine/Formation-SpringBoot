package m2i.spring.exercices.annotations.exo5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Exo5Class {

	@MethodAnnotation
	public void MethodA(@ParamAnnotation String value)
	{
		System.out.println(value);
	}
	

	@MethodAnnotation
	public void MethodB(String value)
	{
		System.out.println(value);
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class<?> clazz = Exo5Class.class;
		Exo5Class exo5 = new Exo5Class();
		
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods)
		{
			Parameter[] parameters = method.getParameters();
			
			if (parameters.length != 1)
			{
				System.out.println("Attention il faut un paramètre !");
			}
			else
			{
				String value = parameters[0].isAnnotationPresent(ParamAnnotation.class) ? "With annotation" : "Without annotation";
				method.invoke(exo5, value);
			}
		}
	}
}

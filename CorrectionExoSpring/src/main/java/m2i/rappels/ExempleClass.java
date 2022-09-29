package m2i.rappels;

import java.lang.annotation.Annotation;

public class ExempleClass {

	public void ExempleMethod()
	{
		if (3 == 3)
			System.out.print("toto");
	}
	
	public static void main(String[] args)
	{
		ExempleClass toto = new ExempleClass();
		toto.ExempleMethod();
		
		Class<?> clazz = ExempleClass.class;
		Annotation[] annotations = clazz.getAnnotations();
		
		for (Annotation annotation : annotations)
			System.out.println(annotation);
	}
}

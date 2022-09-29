package m2i.spring.exercices.annotations.exo5;

public class SomeClass {

	@MethodAnnotation
	public void methodA(@ParamAnnotation String a) {
		System.out.println(a);
	}
	
	@MethodAnnotation
	public void methodB(String b) {
		System.out.println(b);
	}

}

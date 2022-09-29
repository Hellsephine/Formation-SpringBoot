package m2i.spring.exercices.annotations.exo3;

public class SomeClass {
	
	@MethodAnnotation
	public void annotatedMethodA() {
		String A = "Je suis la première méthode";
		System.out.println(A);
	}
	
	@MethodAnnotation
	public void annotedMethodB() {
		String B = "Je suis la deuxième méthode";
		System.out.println(B);
	}
	
	public static void notAnnotatedMethod() {
		String C = "Raté !";
		System.out.println(C);
	}
}

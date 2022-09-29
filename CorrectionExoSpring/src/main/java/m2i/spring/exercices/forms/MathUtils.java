package m2i.spring.exercices.forms;

public final class MathUtils {

	private MathUtils() { }
	
	public static int computeFactoriel(int n)
	{
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
}

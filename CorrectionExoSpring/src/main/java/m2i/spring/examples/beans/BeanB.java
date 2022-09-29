package m2i.spring.examples.beans;


public class BeanB {

	private BeanA beanA;
	
	public BeanB(BeanA beanA)
	{
		this.beanA = beanA;	
	}
	
	public BeanA getBeanA()
	{
		return beanA;
	}
}

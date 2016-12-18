package SourceCode;

public class Additive extends Arithmatic{
	public String calculate(int a,int b,char c)
	{
		if(c=='-')
			ans = substract(a,b);
		if(c=='+')
			ans = add(a,b);
		return ans;
	}
	private String substract(int a,int b)
	{
		String ans;
		ans = Integer.toString(a-b);
		return ans;
	}
	private String add(int a,int b)
	{
		String ans;
		ans = Integer.toString(a+b);
		return ans;
	}

}

package SourceCode;

public class Multiplicative extends Arithmatic{
	public String calculate(int a,int b,char c)
	{
		if(c=='*')
			ans = multiply(a,b);
		if(c=='/')
			ans = divide(a,b);
		if(c=='%')
			ans = modulo(a,b);
		return ans;
	}
	private String multiply(int a,int b)
	{
		String ans;
		ans = Integer.toString(a*b);
		return ans;
	}
	private String divide(int a,int b)
	{
		String ans;
		try{
			ans = Integer.toString(a/b);
		}
		catch(ArithmeticException e)
		{
			ans = "INF";
		}
		return ans;
	}
	private String modulo(int a,int b)
	{
		String ans="";
		Bitwise bitwise = new Bitwise();
		if(bitwise.calculate(b, b-1, '&').equals("0"))
		{
			ans = bitwise.calculate(a,b-1,'&');
		}
			
		ans = Integer.toString(a%b);
		return ans;
	}

}

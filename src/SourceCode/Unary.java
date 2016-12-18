package SourceCode;

public class Unary {
	String ans="";
	public String calculate(int a,char c)
	{
		if(c=='~')
			ans = Integer.toString(~a);
		if(c=='+')
			ans = Integer.toString(a);
		if(c=='-')
			ans = Integer.toString(-a);
		if(c=='!')
			ans = Integer.toString(a!=0?0:1);
		return ans;
	}

}

package SourceCode;

public class Bitwise {
	String ans="";
	public String calculate(int a, int b,char c)
	{
		Equality equality = new Equality();
		if(equality.equate(c, '&'))
			ans = Integer.toString(a&b);
		if(equality.equate(c, '|'))
			ans = Integer.toString(a|b);
		if(equality.equate(c, '^'))
			ans = Integer.toString(a^b);
		return ans;
	}

}

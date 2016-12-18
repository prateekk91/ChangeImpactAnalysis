package SourceCode;

public class Prefix {
	public String calculate(int a,String s)
	{
		String ans="";
		Additive additive = new Additive();
		if(s.equals("++"))
		{
			ans = additive.calculate(a, 1, '+');
		}
		else
		{
			ans = additive.calculate(a, 1, '-');
		}
		return ans;
	}

}

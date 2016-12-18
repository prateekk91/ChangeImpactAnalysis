package SourceCode;

public class Shift {
	String ans="";
	public String calculate(int a,int b,String s)
	{
		if(s.equals(">>"))
		{
			ans = Integer.toString(a>>b);
		}
		else
			ans = Integer.toString(a<<b);
		return ans;
	}

}

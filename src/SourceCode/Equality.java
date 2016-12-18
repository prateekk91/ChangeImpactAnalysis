package SourceCode;

public class Equality {
	public boolean equate(int a,int b)
	{
		if(a==b)
			return true;
		else
			return false;
	}
	public boolean equate(char a,char b)
	{
		if(a==b)
			return true;
		else
			return false;
	}
	public boolean equate(String a,String b)
	{
		if(a.equalsIgnoreCase(b))
			return true;
		else
			return false;
	}

}

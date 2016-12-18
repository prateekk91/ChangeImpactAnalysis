package SourceCode;

public class Compute {
	public Compute()
	{
		
	}
	public String compute(String input)
	{
		input.trim();
		System.out.println(input);
		int firstNumber,SecondNumber;
		String operation;
		String ans="";
		char firstChar = input.charAt(0);
		if(firstChar <='0' || firstChar >='9')
		{
			char secondChar = input.charAt(1);
			if(secondChar<='0' || secondChar >='9')
			{
				operation = input.substring(0,2);
				firstNumber = Integer.parseInt(input.substring(2));
				Prefix prefix = new Prefix();
				ans = prefix.calculate(firstNumber,operation);
			}
			else
			{
				firstNumber = Integer.parseInt(input.substring(1));
				Unary unary = new Unary();
				ans = unary.calculate(firstNumber,firstChar);
			}
				
		}
		else
		{
			for(int i=0;i<input.length();i++)
			{
				char c = input.charAt(i);
				
				if(c=='/' || c=='*'|| c=='%')
				{
					Multiplicative multiplicative = new Multiplicative();
					firstNumber = Integer.parseInt(input.substring(0, i));
					SecondNumber = Integer.parseInt(input.substring(i+1));
					ans = multiplicative.calculate(firstNumber,SecondNumber,c);
					break;
				}
				if(c=='+' || c=='-' )
				{
					Additive additive = new Additive();
					firstNumber = Integer.parseInt(input.substring(0, i));
					SecondNumber = Integer.parseInt(input.substring(i+1));
					ans = additive.calculate(firstNumber,SecondNumber,c);
					break;
				}
				if(c=='&' || c=='|' || c=='^')
				{
					Bitwise bitwise = new Bitwise();
					firstNumber = Integer.parseInt(input.substring(0, i));
					SecondNumber = Integer.parseInt(input.substring(i+1));
					ans = bitwise.calculate(firstNumber,SecondNumber,c);
					break;
				}
				if(c=='>' || c=='<')
				{
					Shift shift = new Shift();
					operation = input.substring(i,i+2);
					firstNumber = Integer.parseInt(input.substring(0, i));
					SecondNumber = Integer.parseInt(input.substring(i+2));
					ans = shift.calculate(firstNumber,SecondNumber,operation);
					break;
				}
			}
		}
		return ans;
	}

}

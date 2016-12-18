package SourceCode;
import java.io.*;
public class Main {
	public static void main(String ab[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while(true)
		{
			System.out.println("Enter the mathematical expression (exit to quit)");
			input = br.readLine();
			if(input.equalsIgnoreCase("exit"))
				break;
			System.out.println(new Compute().compute(input));
		}
	}

}

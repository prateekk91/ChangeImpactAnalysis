package TestCasePackage;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

import SourceCode.*;
import parser.*;
public class Main {
	public static void main(String ab[]) throws IOException
	{
		String changeClass;
		int countTestCasesRun=0,countTotalTestCases=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name of class in which change is made:");
		changeClass = br.readLine();
		changeClass = "SourceCode.".concat(changeClass);
		LinkedList<String> dependentClasses= new LinkedList<String>();
		Dependency dependency = new Dependency("src\\SourceCode\\ClassDiagram.ucls");
		dependency.getClasses();
		dependency.generateDependencies();
		dependentClasses =  dependency.doBFS(dependency.getIdByClass(changeClass));
		FileReader fr = new FileReader("src\\TestCasePackage\\TestCases.txt");
		br = new BufferedReader(fr);
		String testCase;
		while((testCase = br.readLine())!=null)
		{
			StringTokenizer st = new StringTokenizer(testCase,"\t\n ");
			String test = st.nextElement().toString();
			String className = st.nextElement().toString();
			if(dependentClasses.contains(className))
			{
				System.out.println(test+" Run...");
				countTestCasesRun++;
			}
			else
				System.out.println(test+" Skip...");
			countTotalTestCases++;
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				
			}
			
		}
		System.out.println("Total Test Cases="+countTotalTestCases);
		System.out.println("Test Cases Required to run again="+countTestCasesRun);
		double reduction = ((double)(countTotalTestCases-countTestCasesRun)/(double)countTotalTestCases)*100;
		System.out.println("Reduction in effort="+(int)reduction+"%");
		
	}

}

package parser;
import java.io.*;
public class DomParser {
	public static void main(String ab[]) throws IOException
	{
		Dependency dependency = new Dependency("src\\SourceCode\\ClassDiagram.ucls");
		dependency.getClasses();
		dependency.generateDependencies();
		for(int i=1;i<=dependency.getMaxId();i++)
			dependency.doBFS(i);
	}
}

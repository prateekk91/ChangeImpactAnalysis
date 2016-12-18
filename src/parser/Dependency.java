package parser;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Dependency {
	private String classes[];
	private Map<String, Integer> classId;
	private LinkedList<String> dependantClasses;
	private int dependencyArray[][];
	private int id;
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;
	public Dependency(String file)
	{
		classes = new String[1000];
		id = 0;
		classId = new HashMap<String, Integer>();
		dependantClasses = new LinkedList<String>();
		File xmlFile = new File(file);
		try{
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public void getClasses()
	{
		
			NodeList nList = doc.getElementsByTagName("class");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				 
				   Node nNode = nList.item(temp);
				   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
				      Element eElement = (Element) nNode;
				      id = Integer.parseInt(eElement.getAttribute("id").toString());
				      classes[id] = eElement.getAttribute("name");
				      classId.put(classes[id], id);
				   }
				}
		
		
	}
	public void generateDependencies()
	{
		dependencyArray = new int[id+1][id+1];
		for(int i=1;i<=id;i++)
			for(int j=1;j<=id;j++)
				dependencyArray[i][j] = 0;
		getDependencies("dependency");
		getDependencies("generalization");
		getDependencies("association");
	}
	private void getDependencies(String dependencyType)
	{
		int source=0,target=0;
		NodeList nList = doc.getElementsByTagName(dependencyType);
		for (int temp = 0; temp < nList.getLength(); temp++) {
			 
			   Node nNode = nList.item(temp);
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 		      Element eElement = (Element) nNode;
			      NodeList childNodes = eElement.getChildNodes();
			      for(int k=0;k<childNodes.getLength();k++){
			    	  Node child = childNodes.item(k);
			    	  if(child.getNodeName().equals("end")){
					      String type = ((Element)child).getAttribute("type");
					      if(type.equals("SOURCE"))
					    	  source = Integer.parseInt(((Element)child).getAttribute("refId"));
					      else
					      {
					    	  target = Integer.parseInt(((Element)child).getAttribute("refId"));
					    	  dependencyArray[target][source] = 1;
					      }
			    	  }
			      }
			  }
		}
	}
	
	public LinkedList<String> doBFS(int id)
	{
		dependantClasses.clear();
		int visited[] = new int[this.id+1];
		for(int i=0;i<=this.id;i++)
			visited[i] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(id);
		visited[id] = 1;
		//System.out.println("\n\n\nDependant classes for " + classes[id] + " are");
		while(!q.isEmpty())
		{
			int cur = q.remove();
			dependantClasses.add(classes[cur]);
			for(int i=1;i<=this.id;i++)
			{
				if(dependencyArray[cur][i]==1 && visited[i]==0)
				{
					q.add(i);
					visited[i]=1;
				}
			}
		}
		return dependantClasses;
	}
		
	
	public String[] getClassArray()
	{
		return classes;
	}
	public int[][] getDependencyArray()
	{
		return dependencyArray;
	}
	
	public int getMaxId()
	{
		return id;
	}
	public int getIdByClass(String className)
	{
		return classId.get(className);
	}
}



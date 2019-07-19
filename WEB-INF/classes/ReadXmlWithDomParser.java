import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;



public class ReadXmlWithDomParser{
	public static void main(String [] args) throws ParserConfigurationException, SAXException,  IOException{

//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

//Build Document
		Document document = builder.parse(new File("../employees.xml"));

//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();

//Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

//Get all employees
		NodeList nList = document.getElementsByTagName("employee");
		System.out.println("============================");

		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			Node node = nList.item(temp);
       System.out.println("");    //Just a separator
       if (node.getNodeType() == Node.ELEMENT_NODE)
       {
    //Print each employee's detail
       	Element eElement = (Element) node;
       	System.out.println("Employee id : "    + eElement.getAttribute("id"));
       	System.out.println("First Name : "  + eElement.getElementsByTagName("firstName").item(0).getTextContent());
       	System.out.println("Last Name : "   + eElement.getElementsByTagName("lastName").item(0).getTextContent());
       	System.out.println("Location : "    + eElement.getElementsByTagName("location").item(0).getTextContent());
       }
   }

   Node node2 = nList.item(1);
   if (node2.getNodeType() == Node.ELEMENT_NODE)
   {

   	System.out.println("get specific number of employee");
    //Print each employee's detail
   	Element eElement2 = (Element) node2;
   	System.out.println("Employee id : "    + eElement2.getAttribute("id"));
   	System.out.println("First Name : "  + eElement2.getElementsByTagName("firstName").item(0).getTextContent());
   	System.out.println("Last Name : "   + eElement2.getElementsByTagName("lastName").item(0).getTextContent());
   	System.out.println("Location : "    + eElement2.getElementsByTagName("location").item(0).getTextContent());
   }
   getXmlItems(7, nList);
   getXmlItemRange(0, 4, nList);
   System.out.println("*********NEXT********");
      getXmlItemRange(5, 9, nList);
       System.out.println("*********NEXT********");
      getXmlItemRange(10, 14, nList);

}


public static void getXmlItems(int index, NodeList nList){
	Node node = null;
	if (nList.getLength() > index){
		node = nList.item(index);
		if (node.getNodeType() == Node.ELEMENT_NODE)
		{

			System.out.println("get specific number of employee");
    //Print each employee's detail
			Element eElement2 = (Element) node;
			System.out.println("Employee id : "    + eElement2.getAttribute("id"));
			System.out.println("First Name : "  + eElement2.getElementsByTagName("firstName").item(0).getTextContent());
			System.out.println("Last Name : "   + eElement2.getElementsByTagName("lastName").item(0).getTextContent());
			System.out.println("Location : "    + eElement2.getElementsByTagName("location").item(0).getTextContent());
		}

	}
	else{
		System.out.println("You entered: "  + index + ", Unacceptable input::: Your value must be less than " + nList.getLength());
	}

}
public static void getXmlItemRange(int start, int end, NodeList nList){
	Node node = null;
	if (nList.getLength() > end){
		for (int temp = start; temp <= end; temp++)
		{
			node = nList.item(temp);
       System.out.println("");    //Just a separator
       if (node.getNodeType() == Node.ELEMENT_NODE)
       {
    //Print each employee's detail
       	Element eElement = (Element) node;
       	System.out.println("Employee id : "    + eElement.getAttribute("id"));
       	System.out.println("First Name : "  + eElement.getElementsByTagName("firstName").item(0).getTextContent());
       	System.out.println("Last Name : "   + eElement.getElementsByTagName("lastName").item(0).getTextContent());
       	System.out.println("Location : "    + eElement.getElementsByTagName("location").item(0).getTextContent());
       }
   }


	}
	else{
		System.out.println("You entered: "  + start + " to " + end +  ", Unacceptable input::: Your to-value must be less than " + nList.getLength());
	}

}
}
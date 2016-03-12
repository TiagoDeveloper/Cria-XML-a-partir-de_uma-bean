import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CriaXML {

	private Element neto;
	private Attr attrType;
	
	public CriaXML(Object classe) throws ParserConfigurationException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, TransformerException{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		DocumentBuilder db = dbf.newDocumentBuilder();		
		Document doc = db.newDocument();
		
		
		Element pricipal = doc.createElement(classe.getClass().getPackage().getName());
		doc.appendChild(pricipal);
		
		
		Element filho = doc.createElement(classe.getClass().getSimpleName());
		pricipal.appendChild(filho);
	
	
		for(Field field : classe.getClass().getDeclaredFields()){
			
			neto =  doc.createElement(field.getName());
			attrType = doc.createAttribute("type");
			attrType.setValue(field.getType().getName());
			neto.setAttributeNode(attrType);
			neto.appendChild(doc.createTextNode(classe.getClass().getDeclaredMethod("get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1), null).invoke(classe, null).toString()));
			filho.appendChild(neto);

		}//fim do for
		
				
		 TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("C:\\Users\\e222986\\Desktop\\"+ classe.getClass().getSimpleName()+".xml"));
         transformer.transform(source, result);
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
	
	}//fim do construtor
}

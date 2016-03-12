import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import br.com.tiagoDeveloper.criarXML.CriaXML;


public class main {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws TransformerException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		
		
		
		Funcionario gerente = new Funcionario();
		gerente.setNome("Sicrano");
		gerente.setCargo("Gerente de projetos");
		gerente.setRegistro(07);//observação didática: não trabalhar com número com zero a esquerda, 
		//pois acima de 07 é octal (talvez usar o metodo format para trata-los
		
		gerente.setSalario(11800.00);

		
		CriaXML cria = new CriaXML(gerente);

	}

}

package pythonError.errorInterpreter.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pythonError.errorInterpreter.errorSearch.BoyerMoore;
import pythonError.errorInterpreter.inputPhaser.Error;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Christopher on 6/20/2016.
 */
public class XMLLoader {

	public static Map<String, Error> loadExceptions(String path) {
		// Create an XML Document object
		Document xmlDoc = getDocument(path);
		assert xmlDoc != null;
		return loadExceptions(xmlDoc);
	}

	private static Map<String, Error> loadExceptions(Document xmlDoc) {
		NodeList exceptionNodes = xmlDoc.getElementsByTagName("exception");

		// Create an array of Strings for each entity parameter
		List<String> names = getElement(exceptionNodes, "name");
		List<String> explanations = getElement(exceptionNodes, "explanation");
		List<String> simpleExplanations = getElement(exceptionNodes, "simple-explanation");
		List<String> solutions = getElement(exceptionNodes, "solution");

		// Create an array of entity objects
		Map<String, Error> exceptions = new HashMap<>();

		// Create entities from the arrays of strings
		for (int i = 0; i < names.size(); i++)
			exceptions.put(names.get(i), new Error(BoyerMoore.compile(names.get(i)), explanations.get(i), simpleExplanations.get(i), solutions.get(i)));

		return exceptions;
	}

	private static Document getDocument(String path) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setValidating(true);

			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setErrorHandler(null);

			return builder.parse(Class.class.getResourceAsStream(path));

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static List<String> getElement(NodeList entities, String elementName) {
		List<String> elements = new ArrayList<>();
		for (int i = 0; i < entities.getLength(); i++) {
			Node entityNode = entities.item(i);
			Element entityElement = (Element) entityNode;
			NodeList nameList = entityElement.getElementsByTagName(elementName);
			Element nameElement = (Element) nameList.item(0);
			NodeList elementList = nameElement.getChildNodes();
			elements.add(elementList.item(0).getNodeValue().trim());
		}
		return elements;
	}
}

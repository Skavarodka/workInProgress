package lab10.Ex1_;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main_Ex1 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("src/lab10/Ex1_/example.xml"));
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/lab10/Ex1_/example.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NodeList nodeList = doc.getElementsByTagName("TEST");


    }

//    List<Element> books = nodeList.stream()
//            .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
//            .map(node -> (Element) node)
//            .filter(element -> {
//                String author = element.getElementsByTagName("author").item(0).getTextContent();
//                String year = element.getElementsByTagName("year").item(0).getTextContent();
//                return author.equalsIgnoreCase("Лев Толстой") && year.equals("1869");
//            })
//            .collect(Collectors.toList());

//    Transformer transformer =
//            TransformerFactory.newInstance().newTransformer();
//    DOMSource source = new DOMSource(doc);
//    StreamResult result = new StreamResult(new File("src/lr10/example1/example.xml"));
//transformer.transform(source, result);

}

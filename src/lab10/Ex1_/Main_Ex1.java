package lab10.Ex1_;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_Ex1 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String filePath = "src/lab10/Ex1_/example.xml";
        Document doc = builder.parse(filePath);
        doc.getDocumentElement().normalize();

        try {
            addNewBooks(doc);
            searchElementByYear(doc);
            removeElementBook(doc);

            //запись в новый файл
            doc.getDocumentElement().normalize();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/lab10/Ex1_/example2.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("Write complete");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//4. Реализуйте функцию удаления книги из XML-файла.
//Например, пользователь может ввести название книги, которую хочет удалить,
//и программа удалит соответствующий элемент <book> из XML-файла.

    public static void removeElementBook(Document document) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of books to be deleted");
        String deleteElement = in.nextLine();
        NodeList rootElement = document.getElementsByTagName("book");
        Element elementRoot;
        for (int i = 0; i < rootElement.getLength(); i++) {
            elementRoot = (Element) rootElement.item(i);
            Element deleteTitle = (Element) elementRoot.getElementsByTagName("title").item(0);
            String strDeleteTitle = deleteTitle.getTextContent();
            if (strDeleteTitle.equals(deleteElement)) {
                elementRoot.getParentNode().removeChild(elementRoot);
            }
        }
    }

//3.Добавьте возможность поиска книг по автору или году издания.
//Например, пользователь может ввести автора или год издания, а программа выведет список книг,
//удовлетворяющих этому критерию поиска.

    public static void searchElementByYear(Document document) throws XPathExpressionException {
        List<String> list = new ArrayList<>();
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the year for search");
        XPathExpression xPathExpression = xPath.compile("/library/book[year=" + in.nextInt() + "]/title/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            list.add(nodeList.item(i).getNodeValue());
        }
        System.out.println(list);
    }


//2.Добавьте возможность записывать новые книги в XML-файл.
//Например, пользователь может ввести данные о новой книге, а программа добавит новый элемент <book> в XML-файл.
    public static void addNewBooks(Document doc) {
        NodeList rootElement = doc.getElementsByTagName("library");
        Element elementRoot;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < rootElement.getLength(); i++) {
            elementRoot = (Element) rootElement.item(i);

        System.out.println("Enter book name");
        Element book = doc.createElement("book");
        elementRoot.appendChild(book);

        Element title = doc.createElement("title");
        title.appendChild(doc.createTextNode(in.nextLine()));
            book.appendChild(title);

        System.out.println("Enter author name");
        Element author = doc.createElement("author");
        author.appendChild(doc.createTextNode(in.nextLine()));
            book.appendChild(author);

        System.out.println("Enter year");
        Element year = doc.createElement("year");
        year.appendChild(doc.createTextNode(in.nextLine()));
            book.appendChild(year);

        System.out.println("Books add");}
    }

//            try {
//            Transformer transformer = TransformerFactory.newInstance().newTransformer();
//            DOMSource source = new DOMSource(doc);
//            StreamResult result = new StreamResult(new File(filePath));
//            transformer.transform(source, result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        NodeList nodeList = doc.getElementsByTagName("TEST");

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

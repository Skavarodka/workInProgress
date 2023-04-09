package lab10.Ex1_;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

//Эта программа на Java использует библиотеку javax.xml.parsers для чтения и анализа XML-файла. Программа имеет класс XmlParser,
// в котором есть единственный метод main, который является точкой входа в программу.
//Когда программа запускается, она открывает XML-файл src/lr10/example.xml, используя класс java.io.File,
// который представляет файл на диске. Затем программа создает экземпляр класса javax.xml.parsers.
//DocumentBuilderFactory, который используется для создания javax.xml.parsers.DocumentBuilder, который, в свою очередь,
// используется для создания org.w3c.dom.Document.
//Далее, программа вызывает метод parse у экземпляра DocumentBuilder, передавая в качестве аргумента File, который был создан ранее.
//Этот метод читает XML-файл и возвращает объект Document, который представляет собой древовидное представление содержимого XML-файла.
//Затем программа вызывает метод getDocumentElement у объекта Document, чтобы получить корневой элемент XML-документа.
// С помощью метода getNodeName программа выводит имя корневого элемента на консоль.



public class Ex1_2 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lab10/Ex1_/example.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0 ; i < nodeList.getLength() ; i++) {
                Node node = nodeList.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Название книги: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

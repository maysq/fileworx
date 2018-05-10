package commons;

import org.testng.Assert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadFile {
    public static String readProperty(String file, String propertyName) {
        // Define String variable to save property value there
        String propertyValue = null;
        // Initialize Properties Object
        Properties properties = new Properties();
        try {// Add try catch in case exception happen while reading file
            // Read The Provided File content as inputStream
            // This will retrieve all string content from file
            InputStream inputStream = new FileInputStream (file);
            // Load inputStream Object to Properties
            // This will convert string content to keys and values
            properties.load(inputStream);
            // Return Property value from readPropFile Method
            // Check if Property Name exist
            if (properties.containsKey(propertyName))
                // If exist then return property value
                propertyValue = properties.getProperty(propertyName);
            else// If not exist then return error and fail the test case
                Assert.fail("Property Name isn't exist, " +
                        "check " + propertyName);
        } catch (Throwable throwable) {// In case exception happen
            Assert.fail("Read Property File failed, " +
                    "please check log: \n" + throwable.getMessage());
        }
        // Return property value string
        return propertyValue.toLowerCase ();
    }

    // Read XML File and get specific element from
    protected String readXML(String xmlFile, String element) {
        // Read XML File after applying regex and return the document
        try {
            //Check File status then retrieve the file object
            File Resource = new File(xmlFile);

            //Read provided file and check element exist
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(false);
            documentBuilderFactory.setNamespaceAware(true);

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //Parsing the File data as document
            Document document = documentBuilder.parse(Resource);
            //Formatting File data to start processing
            //There is a bug if you provided a file with unformatted xml it gives error message(catch)
            document.getDocumentElement().normalize();

            // Return element value
            return document.getElementsByTagName(element).item(0).getTextContent();
        } catch (Throwable throwable) {
            Assert.fail("Something went wrong with reading element from XML File: " + throwable.getMessage());
        }
        return null;
    }
}

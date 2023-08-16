package org.example;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Files;
import java.nio.file.Paths;


public class XmlWriter {

    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter(){};

    public static void writeToXml(DataSet dataSet) {
        String directoryPath = "xmlReqs";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "req_" + timestamp + ".xml";

        try {
            JAXBContext context = JAXBContext.newInstance(DataSet.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File directory = new File(directoryPath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    logger.log(Level.INFO, "Directory has been created: {0}", directory.getAbsolutePath());
                } else {
                    logger.log(Level.SEVERE, "Failed to create directory: {0}", directory.getAbsolutePath());
                    return;
                }
            } else {
                logger.log(Level.INFO, "Directory already exists: {0}", directory.getAbsolutePath());
            }

            File outputFile = new File(directory, fileName);

            marshaller.marshal(dataSet, outputFile);
            logger.log(Level.INFO, "XML file has been written successfully: {0}", outputFile.getAbsolutePath());
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "An error occurred during XML writing: {0}", e.getMessage());
        }
    }
}

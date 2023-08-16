package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public static void writeToJson(DataSet dataSet) {
        String directoryPath = "jsonReqs";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(dataSet.getExecDate());
        String fileName = "req_" + timestamp + ".json";
        String json = JsonUtil.toJson(dataSet);

        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    logger.log(Level.INFO, "Directory has been created: {0}", directory.getAbsolutePath());
                } else {
                    logger.log(Level.SEVERE, "Failed to create directory: {0}", directory.getAbsolutePath());
                    return; // Прекращаем запись, так как нет директории
                }
            } else {
                logger.log(Level.INFO, "Directory already exists: {0}", directory.getAbsolutePath());
            }

            File outputFile = new File(directory, fileName);
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(json);
            }
            logger.log(Level.INFO, "JSON file has been written successfully: {0}", outputFile.getAbsolutePath());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred during JSON writing: {0}", e.getMessage());
        }
    }
}

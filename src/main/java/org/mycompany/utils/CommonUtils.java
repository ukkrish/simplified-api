package org.mycompany.utils;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Properties;

public class CommonUtils {

    public String getProperty(String key) {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("./src/test/resources/config/staging_env_config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop.getProperty(key);

    }

    public HashMap paramsSplitting(String params) {
        String[] eachParam = null;
        HashMap paramsList = new HashMap();
        if (!params.equals("")) {
            System.out.println("Original Qury-params are: " + params);
            String[] paramArray = params.split("#");
            for (String s : paramArray) {
                if (!s.equals("")) {
                    eachParam = s.split("=");
                    //requestSpecification.queryParam(eachParam[0], eachParam[1]);
                    paramsList.put(eachParam[0], eachParam[1]);
                }
            }
        }
        return paramsList;
    }

    public JSONObject loadJsonFile(String jsonFilePath) throws IOException, ParseException
    {
        System.out.println("Before Lookup from JSON: " + jsonFilePath);
        JSONParser parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource((jsonFilePath));
        //String file = resource.getFile();
        String dr = URLDecoder.decode(classLoader.getResource(jsonFilePath).getFile(), "UTF-8");
        System.out.println("Before Lookup from JSON: " + dr);
        FileReader fr = new FileReader(dr);
        return (JSONObject)parser.parse(fr);  //Return an object and downcast to JSON Object
    }

    public File loadFile(String filePath) {
        File file_from_givenLocation = null;
        try{
            file_from_givenLocation = new File(filePath);
            if(!file_from_givenLocation.exists()){
                System.out.println("File does not exist in this location: "+filePath);
            }
        }catch(Exception exp){
            System.out.println("Exception in loading the file! "+exp);
        }
        return file_from_givenLocation;
    }

}

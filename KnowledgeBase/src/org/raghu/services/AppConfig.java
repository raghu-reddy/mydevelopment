package org.raghu.services;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class AppConfig {
    
    private static AppConfig appConfig;
    private String contentsSrcName;
    private String contentsSrcType;
    
    private AppConfig() {
        File configFile = new File("config\\app-config.xml");
        
        Document doc = null;
        try {
             doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(configFile);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Element dataSource = (Element) doc.getElementsByTagName("data-source").item(0);
        
        contentsSrcType = dataSource.getElementsByTagName("type").item(0).getTextContent();
        contentsSrcName = dataSource.getElementsByTagName("path").item(0).getTextContent();
        
        //close(configFile);
                
    }
    
    public String getContentsSrcName() {
        return contentsSrcName;
    }

    public String getContentsSrcType() {
        return contentsSrcType;
    }
    
    public static AppConfig getAppConfig() {
        return new AppConfig();
    }
    
    public static void main(String[] args) {
        System.out.println("Source Type : "+ AppConfig.getAppConfig().getContentsSrcType());
        System.out.println("Source Name : "+ AppConfig.getAppConfig().getContentsSrcName());
    }
    
}

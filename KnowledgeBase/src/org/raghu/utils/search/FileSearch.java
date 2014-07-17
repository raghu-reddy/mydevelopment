package org.raghu.utils.search;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.raghu.utils.reader.All;
import org.raghu.utils.reader.ErrorReadingSourceException;
import org.raghu.utils.reader.InputFileReader;
import org.raghu.utils.reader.InputReader;
import org.raghu.utils.reader.LinesArrayList;
import org.raghu.utils.reader.Reader;
import org.raghu.utils.reader.ReaderConstants;

public class FileSearch implements Searchable {
    
    String fileLocation;
    
    public FileSearch(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public ArrayList<String> getMatches(String searchStr) {
        
        ArrayList<String> results = new ArrayList<>();
        InputReader contentsFile = null;
        ArrayList<String> contents = new ArrayList<>();
        
        try {
            System.out.println("Opening : "+fileLocation);
             contentsFile = new InputFileReader(fileLocation);
        } catch (ErrorReadingSourceException e) {
            e.printStackTrace();
            System.exit(0);
        }
        
        contents = ((LinesArrayList) Reader.readNext(contentsFile, ReaderConstants.LINES_ARRAYLIST)).getContent();
       
        Pattern pattern = Pattern.compile(searchStr);
        StringBuilder strBldr = new StringBuilder(
                fileLocation.substring(0, fileLocation.lastIndexOf("\\")+1));
        strBldr.append("datafiles\\\\");
        
        
        for (String current: contents) {
            Matcher matcher = pattern.matcher(current);
            String location = strBldr+current.split(":")[1];
            int currentLevel = current.lastIndexOf(",");
            String description = current.substring(currentLevel+1, current.lastIndexOf(":"));
            if (matcher.find()) {
                results.add(description);                
            } else {
                InputReader tempReader = null;
                try {
                    System.out.println("Opening : "+location);
                    tempReader = new InputFileReader(location);
                } catch (ErrorReadingSourceException ex) {
                    ex.printStackTrace();
                    System.exit(0);
                }
                Matcher tempMatcher = pattern.matcher(
                        ((All) Reader.readNext(tempReader, ReaderConstants.ALL)).toString()
                );
                if (tempMatcher.find()) {
                    results.add(description);
                }
            }
        }
        return results;
    }
    
}

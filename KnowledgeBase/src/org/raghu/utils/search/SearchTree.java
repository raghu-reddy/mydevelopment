package org.raghu.utils.search;

import java.util.ArrayList;

public class SearchTree {
    
    String srcType;
    String srcPath;
    Searchable searchable;
    
    public SearchTree(String srcType, String srcPath) {
        this.srcPath = srcPath;
        this.srcType = srcType;
        init();
    }    

    private void init() {
        switch(srcType) {
            case "file": 
                searchable = new FileSearch(srcPath);
                break;
            case "database-oracle": break;
            default: System.out.println("Unknown source type");
        }
    }
    
    public ArrayList<String> searchTree(String searchStr) {
        return searchable.getMatches(searchStr);
    }
}

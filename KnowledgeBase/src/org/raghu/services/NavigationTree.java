package org.raghu.services;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.raghu.utils.application.AppObjects;
import org.raghu.utils.reader.ErrorReadingSourceException;
import org.raghu.utils.reader.InputFileReader;
import org.raghu.utils.reader.InputReader;
import org.raghu.utils.reader.LinesArrayList;
import org.raghu.utils.reader.Reader;
import org.raghu.utils.reader.ReaderConstants;

public class NavigationTree {

    private static final String contentsSrcType = AppConfig.getAppConfig().getContentsSrcType();
    private static final String contentsSrcName = AppConfig.getAppConfig().getContentsSrcName();
    private JTree jTree;

    public NavigationTree() {
        fillTree();
    }
    
    public JTree getTree() {
        return jTree;
    }
    
    private void fillTree() {
        
        ArrayList<String> contentsArray = null;
        
        switch (contentsSrcType) {
            case "file":
                contentsArray = readFromFile(contentsSrcName);
                break;
            case "database-oracle":
                contentsArray = readFromOracle(contentsSrcName);
                break;
            default:
                System.out.println("Unknown Source");
        }
        
        HashMap<Integer, DefaultMutableTreeNode> levelRootMap = 
                new HashMap<Integer, DefaultMutableTreeNode>();
        

        DefaultMutableTreeNode dNode = new DefaultMutableTreeNode(new NavigationNode("Root", "0.txt"));
        DefaultTreeModel treeModel = new DefaultTreeModel(dNode);
        jTree = new JTree(treeModel);

        int lastLevel = -1;
        levelRootMap.put(lastLevel, dNode);
        DefaultMutableTreeNode currentRoot = dNode;
        DefaultMutableTreeNode lastNode = dNode;
                
        for (String rec: contentsArray) {
            String location = rec.split(":")[1];
            int currentLevel = rec.lastIndexOf(",");
            String description = rec.substring(currentLevel+1, rec.lastIndexOf(":"));
            DefaultMutableTreeNode currentNode = 
                        new DefaultMutableTreeNode(new NavigationNode(description, location));
            if (currentLevel > lastLevel) {
                levelRootMap.put(lastLevel, lastNode);
                currentRoot = lastNode;
            } else if (currentLevel < lastLevel) {
                currentRoot = levelRootMap.get(currentLevel-1);
            }
            lastLevel = currentLevel;
            currentRoot.add(currentNode);
            lastNode = currentNode;
        }
        
    }

    private ArrayList<String> readFromFile(String fileName) {
        ArrayList<String> array = null;

        InputReader reader = null;

        try {
            reader = new InputFileReader(fileName);
        } catch (ErrorReadingSourceException e) {
            System.exit(0);
        }
        
        array = ((LinesArrayList) Reader.readNext(reader, ReaderConstants.LINES_ARRAYLIST)).getContent();

        return array;
    }
    
    public ArrayList<String> readFromOracle(String databaseURL) {
        return null;
    }
    
    public static void main(String[] args) {
        NavigationTree nTree = new NavigationTree();
    }

}

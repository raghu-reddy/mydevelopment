package org.raghu.gui.eventhandling;

import java.util.Enumeration;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.raghu.services.NavigationNode;
import org.raghu.utils.application.AppObjects;

public class ResultsSelectionListener implements ListSelectionListener {

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String result = (String) ((JList) e.getSource()).getSelectedValue();
        result = result==null?"Root":result;
        System.out.println("Value Changed : "+result);
        
        JTree jTree = (JTree) AppObjects.getAppObject("NavigationTree");
        System.out.println("Got the Tree Object : "+jTree);
        //jTree.setSelectionRow(getTreePath(jTree, result));
        //jTree.setSelectionRow(2);
        TreePath treePath = getTreePath(jTree, result);
        jTree.setSelectionPath(treePath);
        //jTree.scrollPathToVisible(jTree.getSelectionPath());
        expandNode(jTree, treePath);
    }
    
    private void expandNode(JTree jTree, TreePath parent) {
        TreeNode node = (TreeNode)parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            Enumeration e = node.children();
            while(e.hasMoreElements()) {
                TreeNode n = (TreeNode)e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandNode(jTree, path);
            }
        }
        jTree.expandPath(parent);
    }
    
    private TreePath getTreePath(JTree jTree, String result) {
        TreeModel treeModel = jTree.getModel();
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        System.out.println("Got the root : "+((NavigationNode) rootNode.getUserObject()).getContentLocation());
        Enumeration treeEnum = rootNode.breadthFirstEnumeration();
        
        while (treeEnum.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeEnum.nextElement();
            System.out.println("Got the child : "+((NavigationNode) node.getUserObject()).getContentLocation());
            if (((NavigationNode) node.getUserObject()).getDescription().equals(result)) {
                System.out.println("Got the result : "+node);
                return new TreePath(node);
            }
        }
        return new TreePath(rootNode);
    }
    
}

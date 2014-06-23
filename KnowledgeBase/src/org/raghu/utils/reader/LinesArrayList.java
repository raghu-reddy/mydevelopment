package org.raghu.utils.reader;

import java.util.ArrayList;

public class LinesArrayList implements ReaderElement {

    ArrayList<String> content;

    LinesArrayList(ArrayList<String> linesArrayList) {
        this.content = linesArrayList;
    }

    public ArrayList<String> getContent() {
        return content;
    }
    
    @Override
    public String toString() {
        if (content != null) {
            return content.toString();
        }
        return null;
    }
}

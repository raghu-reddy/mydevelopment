package org.raghu.utils.reader;

public class Word implements ReaderElement {

    String content;

    Word(String str) {
        this.content = str;
    }

    public String toString() {
        if (content != null) {
            return content.toString();
        }
        return null;
    }
}

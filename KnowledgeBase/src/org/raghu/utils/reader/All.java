package org.raghu.utils.reader;

public class All implements ReaderElement {

    String content;

    All(String str) {
        this.content = str;
    }

    @Override
    public String toString() {
        if (content != null) {
            return content;
        }
        return null;
    }
}

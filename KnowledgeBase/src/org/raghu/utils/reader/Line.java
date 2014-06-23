package org.raghu.utils.reader;

public class Line implements ReaderElement {

    String content;

    Line(String str) {
        this.content = str;
    }

    public String toString() {
        return content;
    }
}

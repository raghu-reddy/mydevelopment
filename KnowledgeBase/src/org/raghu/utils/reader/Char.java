package org.raghu.utils.reader;

public class Char implements ReaderElement {

    Character content;

    Char(Character chr) {
        this.content = chr;
    }

    public String toString() {
        if (content != null) {
            return content.toString();
        }
        return null;
    }
}

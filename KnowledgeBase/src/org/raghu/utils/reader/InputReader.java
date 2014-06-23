package org.raghu.utils.reader;

public interface InputReader {

    ReaderElement read(ReaderConstants rc) throws ErrorReadingSourceException;

    void close();

}

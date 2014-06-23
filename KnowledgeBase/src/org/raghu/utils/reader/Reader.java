package org.raghu.utils.reader;

public class Reader {

    public static ReaderElement readNext(InputReader ir, ReaderConstants rc) {

        ReaderElement re = null;
        try {
            re = ir.read(rc);
        } catch (ErrorReadingSourceException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            return (re.toString() == null) ? null : re;
        }
    }

}

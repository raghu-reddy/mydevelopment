package org.raghu.utils.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFileReader implements InputReader {

    private BufferedReader myFile;

    public InputFileReader(String fileName) throws ErrorReadingSourceException {
        try {
            myFile = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            if (myFile != null) {
                try {
                    myFile.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            throw new ErrorReadingSourceException(this.getClass().getName()
                    + " Constructor");
        }

    }

    @Override
    public ReaderElement read(ReaderConstants rc) throws ErrorReadingSourceException {

        if (myFile == null) {
            throw new ErrorReadingSourceException(this.getClass().getSimpleName()
                    + " read()");
        }

        switch (rc) {
            case LINE:
                try {
                    return new Line(myFile.readLine());
                } catch (IOException e) {
                    throw new ErrorReadingSourceException(this.getClass().getSimpleName()
                            + " read()");
                }
            case LINES_ARRAYLIST:
                try {
                    ArrayList<String> arrayList = new ArrayList();
                    String str = myFile.readLine();

                    while (str != null) {
                        arrayList.add(str);
                        str = myFile.readLine();
                    }
                    return new LinesArrayList(arrayList);
                } catch (IOException e) {
                    throw new ErrorReadingSourceException(this.getClass().getSimpleName()
                            + " read()");
                }
            case CHAR:
                try {
                    int result = myFile.read();
                    Character ch = null;
                    if (result != -1) {
                        ch = (char) result;
                    }
                    return new Char(ch);
                } catch (IOException e) {
                    throw new ErrorReadingSourceException(this.getClass()
                            .getSimpleName() + " read()");
                }

            case WORD:
                try {
                    StringBuilder sb = new StringBuilder();
                    String str = null;

                    str = myFile.readLine();

                    while (str != null) {
                        sb.append(str + "\n");
                        str = myFile.readLine();
                    }

                    String result = null;

                    if (sb.length() != 0) {
                        result = sb.toString();
                    }
                    return new All(result);

                } catch (IOException e) {
                    throw new ErrorReadingSourceException(this.getClass()
                            .getSimpleName() + " read()");
                }

            case ALL:
                try {
                    StringBuilder sb = new StringBuilder();
                    String str = null;

                    str = myFile.readLine();

                    while (str != null) {
                        sb.append(str + "\n");
                        str = myFile.readLine();
                    }

                    String result = null;

                    if (sb.length() != 0) {
                        result = sb.toString();
                    }
                    return new All(result);

                } catch (IOException e) {
                    throw new ErrorReadingSourceException(this.getClass()
                            .getSimpleName() + " read()");
                }
            default:
                break;
        }
        return null;
    }

    public void close() {
        if (myFile != null) {
            try {
                myFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

package com.iz0819.www.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CatFile {
    public static void main(String args[])  {
        //if (args.length != 1) {
        //    throw new FileNotFoundException("File name is not supplied");
        //}
        String fileName = "/Users/prajpoot/IdeaProjects/IZ0819/src/com/iz0819/www/Editor.java";
        int ch;
        try ( FileInputStream fin = new FileInputStream(fileName)) {
            do {
                ch = fin.read();
                if (ch != -1) { System.out.print((char)ch); }
            } while (ch != -1);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

package com.iz0819.www.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesFromDirectory {
    public static void main(String args[]) {
        File f = new File("./src/com/iz0819/www");
        for(String f1 : f.list() ) {
            System.out.println(f1);
        }

        System.out.println("================================");
        try(Stream<Path> walk = Files.walk(Paths.get("./src/com/iz0819/www"))) {
            walk.filter(x -> x.getFileName().toString().startsWith("f")).forEach(System.out::println);
            //walk.map(x -> x.getFileName() + " " + x.getFileName().startsWith("f")).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

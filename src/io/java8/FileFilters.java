package io.java8;

import java.io.File;
import java.io.FileFilter;

public class FileFilters {
    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        File dir = new File("/tem");
        File[] files = dir.listFiles(fileFilter);

        for (File f : files){
            System.out.println(f);
        }
    }
}

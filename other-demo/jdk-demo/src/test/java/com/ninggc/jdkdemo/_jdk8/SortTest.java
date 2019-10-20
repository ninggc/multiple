package com.ninggc.jdkdemo._jdk8;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;

public class SortTest {

    @Test
    public  void main() {
        ArrayList<Sort.Number> numbers = new ArrayList<>();
        numbers.sort(Comparator.comparing(Sort.Number::getValue));

        numbers.stream();
        File[] files = new File("").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });

        File[] files1 = new File("").listFiles(File::isHidden);

    }
}
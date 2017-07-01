package com.github.wslf.utils.file;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reader class is class for simplifying reading from text files.
 *
 * @author Wsl_F
 */
public class Reader {

    /**
     * Read all lines of the text file into the list of String.
     *
     * @param fileName absolute or relative path to the file to be read
     * @return ArrayList of String that contains all lines of {@code fileName}.
     * if {@code fileName} wasn't read successfully returns {@code null}.
     */
    public ArrayList<String> getLines(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> lines;
            lines = stream.collect(Collectors.toList());
            return new ArrayList<>(lines);
        } catch (Exception ex) {
            System.err.println("Failed to read file: " + fileName
                    + "\n" + ex.toString());
            return null;
        }
    }
}

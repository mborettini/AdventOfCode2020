package main;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUpload {

    public static List<String> uploadStringsFile(Path path) {
        List<String> stringsFileContent = new ArrayList<>();
        try (Scanner in = new Scanner(Files.newInputStream(path))) {
            while (in.hasNext()) {
                String elem = in.nextLine();
                stringsFileContent.add(elem);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return stringsFileContent;
    }

    public static List<Integer> uploadIntegersFile(Path path) {
        List<Integer> integersFileContent = new ArrayList<>();
        try (Scanner in = new Scanner(Files.newInputStream(path))) {
            while (in.hasNext()) {
                Integer elem = in.nextInt();
                integersFileContent.add(elem);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return integersFileContent;
    }


}

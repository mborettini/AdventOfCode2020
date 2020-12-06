package main;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileUpload {

    public static List<String> uploadLineByLine(Path path) {
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

    public static List<Integer> uploadAsConsecutiveNumbers(Path path) {
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

    public static List<String> uploadWithEmptyLineAsSeparatorWithSpaces(Path path) {
        List<String> stringsFileContent = new ArrayList<>();
        String elem = "";
        String line = "";
        try (Scanner in = new Scanner(Files.newInputStream(path))) {
            while (in.hasNext()) {
                elem = in.nextLine() + " ";
                if (!elem.isBlank()) {
                    line = line + elem;
                } else {
                    stringsFileContent.add(line);
                    elem = "";
                    line = "";
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return stringsFileContent;
    }

    public static List<String> uploadWithEmptyLineAsSeparator(Path path) {
        List<String> stringsFileContent = new ArrayList<>();
        String elem = "";
        String line = "";
        try (Scanner in = new Scanner(Files.newInputStream(path))) {
            while (in.hasNext()) {
                elem = in.nextLine();
                if (!elem.isBlank()) {
                    line = line + elem;
                } else {
                    stringsFileContent.add(line);
                    elem = "";
                    line = "";
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return stringsFileContent;
    }

}

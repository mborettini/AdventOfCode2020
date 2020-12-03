package day2;

import main.FileUpload;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CorruptedPasswords extends FileUpload {

    private static int firstPasswordPolicyValidation(List<String> passwords) {
        int start;
        int stop;
        char letter;
        String pass;
        int result = 0;
        for (String s : passwords) {
            int count = 0;
            String[] lineFromFile = s.split(" ");
            String[] range = lineFromFile[0].split("-");
            start = Integer.valueOf(range[0]);
            stop = Integer.valueOf(range[1]);
            letter = lineFromFile[1].charAt(0);
            pass = lineFromFile[2];

            List<Character> lettersFromPass = new ArrayList<>();

            for (int i = 0; i < pass.length(); i++) {
                lettersFromPass.add(pass.charAt(i));
            }

            for (Character c : lettersFromPass) {
                if (c.equals(letter)) {
                    count = count + 1;
                }
            }

            if (start <= count && count <= stop) {
                result = result + 1;
            }

        }
        return result;
    }

    private static int secondPasswordsPolicyValidation(List<String> passwords) {
        Integer place1;
        Integer place2;
        char letter;
        String pass;
        int result = 0;
        for (String s : passwords) {
            String[] array = s.split(" ");
            String[] range = array[0].split("-");
            place1 = Integer.valueOf(range[0]);
            place2 = Integer.valueOf(range[1]);
            letter = array[1].charAt(0);
            pass = array[2];
            String condition1 = String.valueOf(pass.charAt(place1 - 1));
            String condition2 = String.valueOf(pass.charAt(place2 - 1));

            if (condition1.equals(String.valueOf(letter)) || condition2.equals(String.valueOf(letter))) {
                if (condition1.equals(String.valueOf(letter)) && condition2.equals(String.valueOf(letter))) {
                    result = result + 0;
                } else {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final Path passwordsFile = Paths.get("C:", "Users", "magda", "IdeaProjects", "AdventOfCode", "src", "main", "resources", "passwords.txt");
        System.out.println(firstPasswordPolicyValidation(FileUpload.uploadStringsFile(passwordsFile)));
        System.out.println(secondPasswordsPolicyValidation(FileUpload.uploadStringsFile(passwordsFile)));
    }

}

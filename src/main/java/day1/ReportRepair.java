package day1;

import main.FileUpload;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReportRepair<T> extends FileUpload {

    @NotNull
    private static int multiplicationOfTwo(List<Integer> expenses) {
        int first = 0;
        int second = 0;
        for (int i : expenses) {
            for (int j : expenses) {
                if (i + j == 2020) {
                    first = i;
                    second = j;
                }
            }
        }
        return first * second;
    }

    @NotNull
    private static int multiplicationOfThree(List<Integer> expenses) {
        Integer first = 0;
        Integer second = 0;
        Integer third = 0;
        for (int i : expenses) {
            for (int j : expenses) {
                for (int k : expenses) {
                    if (i + j + k == 2020) {
                        first = i;
                        second = j;
                        third = k;
                    }
                }
            }
        }
        return first * second * third;
    }

    public static void main(String[] args) {
        final Path expenseReport = Paths.get("C:", "Users", "magda", "IdeaProjects", "AdventOfCode", "src", "main", "resources", "expense_report.txt");
        System.out.println(multiplicationOfTwo(FileUpload.uploadIntegersFile(expenseReport)));
        System.out.println(multiplicationOfThree(FileUpload.uploadIntegersFile(expenseReport)));
    }

}

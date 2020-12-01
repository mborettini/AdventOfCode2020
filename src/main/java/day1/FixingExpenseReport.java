package day1;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FixingExpenseReport {

    private static List<Integer> uploadExpenseReport() {
        final Path expenseReport = Paths.get("C:", "Users", "magda", "IdeaProjects", "AdventOfCode", "src", "main", "resources", "expense_report.txt");
        List<Integer> expenses = new ArrayList<>();
        try (Scanner in = new Scanner(Files.newInputStream(expenseReport))) {
            while (in.hasNext()) {
                Integer a = in.nextInt();
                expenses.add(a);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return expenses;
    }

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
        List<Integer> expenses = uploadExpenseReport();
        System.out.println(multiplicationOfTwo(expenses));
        System.out.println(multiplicationOfThree(expenses));

    }

}

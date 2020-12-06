package day6;

import main.FileUpload;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CustomCustoms {

    private static List<String> removeDuplicatedLettersInLines(List<String> groupsAnswers) {
        List<String> uniqueGroupAnswers = new LinkedList<>();
        String singleGroupAnswers;
        String singleGroupAnswersWithoutDuplicates = "";
        String letter;
        for (int i = 0; i < groupsAnswers.size(); i++) {
            singleGroupAnswers = groupsAnswers.get(i);
            for (int j = 0; j < singleGroupAnswers.length(); j++) {
                letter = String.valueOf(singleGroupAnswers.charAt(j));
                if (!singleGroupAnswersWithoutDuplicates.contains(letter)) {
                    singleGroupAnswersWithoutDuplicates = singleGroupAnswersWithoutDuplicates + letter;
                }
            }
            uniqueGroupAnswers.add(singleGroupAnswersWithoutDuplicates);
            singleGroupAnswersWithoutDuplicates = "";

        }
        return uniqueGroupAnswers;
    }

    private static long sumAnswers(List<String> uniqueGroupAnswers) {
        long sum = 0;
        for (int i = 0; i < uniqueGroupAnswers.size(); i++) {
            sum = sum + uniqueGroupAnswers.get(i).length();
        }
        return sum;
    }

    private static List<Integer> findYesAnswersForAllGroupMembers(List<String> groupsAnswersSecondApproach) {

        List<Integer> questionsAnsweredPositiveByAllMembers = new ArrayList<>();

        for (int i = 0; i < groupsAnswersSecondApproach.size(); i++) {

            int yesCount = 0;
            List<String> line = Arrays.asList(groupsAnswersSecondApproach.get(i).split(" "));

            for (int j = 0; j < line.get(0).length(); j++) {

                int count = 1;
                String letter = String.valueOf(line.get(0).charAt(j));

                for (int k = 1; k < line.size(); k++) {
                    if (line.get(k).contains(letter)) {
                        count = count + 1;
                    }
                }

                if (line.size() == count) {
                    yesCount = yesCount + 1;
                }

            }
            questionsAnsweredPositiveByAllMembers.add(yesCount);
        }
        return questionsAnsweredPositiveByAllMembers;
    }

    public static void main(String[] args) {
        final Path answersFile = Paths.get("C:", "Users", "magda", "IdeaProjects", "AdventOfCode", "src", "main", "resources", "answers.txt");
        List<String> groupsAnswers = FileUpload.uploadWithEmptyLineAsSeparator(answersFile);
        List<String> uniqueGroupAnswers = removeDuplicatedLettersInLines(groupsAnswers);

        System.out.println(sumAnswers(uniqueGroupAnswers));

        List<String> groupsAnswersSecondApproach = FileUpload.uploadWithEmptyLineAsSeparatorWithSpaces(answersFile);
        List<Integer> questionsAnsweredPositiveByAllMembers = findYesAnswersForAllGroupMembers(groupsAnswersSecondApproach);

        int sum = 0;
        for (int i = 0; i < questionsAnsweredPositiveByAllMembers.size(); i++) {
            sum = sum + questionsAnsweredPositiveByAllMembers.get(i);
        }

        System.out.println(sum);
    }

}



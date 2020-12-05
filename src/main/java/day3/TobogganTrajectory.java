package day3;

import main.FileUpload;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class TobogganTrajectory extends FileUpload {

    private static List<String> extendMapToRight(List<String> map) {
        List<String> extendedMap = new LinkedList<>();
        for (int i = 0; i < map.size(); i++) {
            String extendedLine = map.get(i);
            for (int j = 0; j < i; j++) {
                extendedLine = extendedLine + map.get(i);
            }
            extendedMap.add(extendedLine);
        }
        return extendedMap;
    }

    private static List<String> getCharactersFromTrajectory(List<String> extendedMap, int right, int down) {
        List<String> trajectory = new LinkedList<>();
        int rightSlot = 0;
        String character;
        for (int i = 0; i < (extendedMap.size() - 1); ) {
            rightSlot = rightSlot + right;
            i = i + down;
            character = String.valueOf(extendedMap.get(i).charAt(rightSlot));
            trajectory.add(character);
        }
        return trajectory;
    }

    private static int countTrees(List<String> trajectory) {
        int count = 0;
        String tree = "#";
        for (int i = 0; i < trajectory.size(); i++) {
            String character = trajectory.get(i);
            if (character.equals(tree)) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        final Path mapFile = Paths.get("C:", "Users", "magda", "IdeaProjects", "AdventOfCode", "src", "main", "resources", "map.txt");

        List<String> map = extendMapToRight(FileUpload.uploadStringsFile(mapFile));

        List<String> firstTypeOfSlope = getCharactersFromTrajectory(map, 1, 1);
        List<String> secondTypeOfSlope = getCharactersFromTrajectory(map, 3, 1);
        List<String> thirdTypeOfSlope = getCharactersFromTrajectory(map, 5, 1);
        List<String> fourthTypeOfSlope = getCharactersFromTrajectory(map, 7, 1);
        List<String> fifthTypeOfSlope = getCharactersFromTrajectory(map, 1, 2);

        long firstTreesNumber = countTrees(firstTypeOfSlope);
        long secondTreesNumber = countTrees(secondTypeOfSlope);
        long thirdTreesNumber = countTrees(thirdTypeOfSlope);
        long fourthTreesNumber = countTrees(fourthTypeOfSlope);
        long fifthTreesNumber = countTrees(fifthTypeOfSlope);

        long multiplication = firstTreesNumber * secondTreesNumber * thirdTreesNumber * fourthTreesNumber * fifthTreesNumber;

        System.out.println(multiplication);
    }

}

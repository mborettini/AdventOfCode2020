package day5;

import main.FileUpload;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class BinaryBoarding {

    public static List<Double> convertSeatsIdBinaryToNumerated(List<String> binaryPlaneSeats) {
        List<Double> numeratedPlaneSeats = new LinkedList<>();
        String seatNumber;
        double downRowRange = 0.0;
        double upRowRange = 127.0;
        double downColumnRange = 0.0;
        double upColumnRange = 7.0;
        double result;
        double result1;
        double seatId;
        double row;
        double column;
        for (int i = 0; i < binaryPlaneSeats.size(); i++) {
            column = 0;
            seatNumber = binaryPlaneSeats.get(i);
            for (int j = 0; j < seatNumber.length(); j++) {
                if (!(downRowRange == upRowRange) && j < 7 && seatNumber.charAt(j) == 'F') {
                    result = (upRowRange - downRowRange) / 2 - 0.5;
                    upRowRange = downRowRange + result;
                } else if (!(downRowRange == upRowRange) && j < 7 && seatNumber.charAt(j) == 'B') {
                    result = (upRowRange - downRowRange) / 2 + 0.5;
                    downRowRange = downRowRange + result;
                } else if (!(downColumnRange == upColumnRange) && j >= 7 && seatNumber.charAt(j) == 'L') {
                    result1 = (upColumnRange - downColumnRange) / 2 - 0.5;
                    upColumnRange = downColumnRange + result1;
                    if (j == seatNumber.length() - 1) {
                        column = downColumnRange;
                    }
                } else if (!(downColumnRange == upColumnRange) && j >= 7 && seatNumber.charAt(j) == 'R') {
                    result1 = (upColumnRange - downColumnRange) / 2 + 0.5;
                    downColumnRange = downColumnRange + result1;
                    if (j == seatNumber.length() - 1) {
                        column = downColumnRange;
                    }
                }
                if (j == seatNumber.length() - 1) {
                    row = downRowRange;
                    seatId = row * 8 + column;
                    numeratedPlaneSeats.add(seatId);
                    downRowRange = 0.0;
                    upRowRange = 127.0;
                    downColumnRange = 0.0;
                    upColumnRange = 7.0;
                }
            }
        }
        return numeratedPlaneSeats;
    }

    private static double calculateMaxSeatNumber(List<Double> numeratedPlaneSeats) {
        double max = 0;
        for (int i = 0; i < numeratedPlaneSeats.size(); i++) {
            if (numeratedPlaneSeats.get(i) > max) {
                max = numeratedPlaneSeats.get(i);
            }
        }
        return max;
    }

    private static double findMyPlace(List<Double> numeratedPlaneSeats, int max) {
        double number = 0;
        for (double i = 1; i < max; i++) {
            if (!numeratedPlaneSeats.contains(i) && numeratedPlaneSeats.contains(i - 1) && numeratedPlaneSeats.contains(i + 1)) {
                number = i;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        final Path planeSeatsFile = Paths.get("C:", "Users", "magda", "IdeaProjects", "AdventOfCode", "src", "main", "resources", "plane_seats.txt");
        List<String> binaryPlaneSeats = FileUpload.uploadLineByLine(planeSeatsFile);
        List<Double> numeratedPlaneSeats = convertSeatsIdBinaryToNumerated(binaryPlaneSeats);
        int max = (int) calculateMaxSeatNumber(numeratedPlaneSeats);
        int mySeat = (int) findMyPlace(numeratedPlaneSeats, max);

        System.out.println(max);
        System.out.println(mySeat);
    }
}



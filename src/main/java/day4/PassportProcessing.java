package day4;

import main.FileUpload;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PassportProcessing {

    public static int countValidPassports(List<String> passports) {
        List<String> singlePassport = new ArrayList<>();
        Map<String, String> passportDetails = new HashMap<>();
        List<String> entry;
        int count = 0;
        boolean byrCheck;
        Integer byrValue;
        boolean iyrCheck;
        Integer iyrValue;
        boolean eyrCheck;
        Integer eyrValue;
        boolean hgtCheck1;
        boolean hgtCheck2;
        Integer hgtValue;
        boolean hclCheck;
        boolean eclCheck;
        boolean pidCheck;

        for (int i = 0; i < passports.size(); i++) {
            singlePassport.addAll(Arrays.asList(passports.get(i).split(" ")));
            for (int j = 0; j < singlePassport.size(); j++) {
                entry = Arrays.asList(singlePassport.get(j).split(":"));
                passportDetails.put(entry.get(0), entry.get(1));
            }
            if (passportDetails.containsKey("byr") && passportDetails.containsKey("iyr") && passportDetails.containsKey("eyr") && passportDetails.containsKey("hgt") && passportDetails.containsKey("hcl") && passportDetails.containsKey("ecl") && passportDetails.containsKey("pid")) {

                byrValue = Integer.parseInt(passportDetails.get("byr"));
                byrCheck = passportDetails.get("byr").length() == 4 && byrValue >= 1920 && byrValue <= 2002;

                iyrValue = Integer.parseInt(passportDetails.get("iyr"));
                iyrCheck = passportDetails.get("iyr").length() == 4 && iyrValue >= 2010 && iyrValue <= 2020;

                eyrValue = Integer.parseInt(passportDetails.get("eyr"));
                eyrCheck = passportDetails.get("eyr").length() == 4 && eyrValue >= 2020 && eyrValue <= 2030;

                try {
                    hgtValue = Integer.parseInt(passportDetails.get("hgt").substring(0, passportDetails.get("hgt").length() - 2));
                } catch (NumberFormatException e) {
                    hgtValue = 0;
                }

                hgtCheck1 = passportDetails.get("hgt").matches("^.*cm$") && hgtValue >= 150 && hgtValue <= 193;
                hgtCheck2 = passportDetails.get("hgt").matches("^.*in$") && hgtValue >= 59 && hgtValue <= 76;

                hclCheck = passportDetails.get("hcl").matches("^#[0-9a-f]{6}$");

                eclCheck = passportDetails.get("ecl").equals("amb") || passportDetails.get("ecl").equals("blu") || passportDetails.get("ecl").equals("brn")
                        || passportDetails.get("ecl").equals("gry") || passportDetails.get("ecl").equals("grn") || passportDetails.get("ecl").equals("hzl")
                        || passportDetails.get("ecl").equals("oth");

                pidCheck = passportDetails.get("pid").length() == 9;

                if (byrCheck == true && iyrCheck == true && eyrCheck == true && (hgtCheck1 || hgtCheck2) && hclCheck && eclCheck && pidCheck) {
                    count = count + 1;
                }
            }
            singlePassport.clear();
            passportDetails.clear();
        }
        return count;
    }

    public static void main(String[] args) {
        final Path passportsFile = Paths.get("C:", "Users", "magda", "IdeaProjects", "AdventOfCode", "src", "main", "resources", "passports.txt");
        List<String> passports = FileUpload.uploadWithEmptyLineAsSeparatorWithSpaces(passportsFile);

        System.out.println(PassportProcessing.countValidPassports(passports));
    }
}

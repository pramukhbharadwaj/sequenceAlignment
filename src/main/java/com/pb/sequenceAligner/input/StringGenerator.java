package main.java.com.pb.sequenceAligner.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringGenerator {

    public static void main(String args[]) {
        String filePath = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "pb" + File.separator + "sequenceAligner" + File.separator + "input_Evaluator" + File.separator + "input.txt";
        List<StringBuilder> builders = readFromInputFile(filePath);
        builders.forEach(System.out::println);
    }

    public static List<StringBuilder> readFromInputFile(String filename) {
        List<StringBuilder> outputList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                list.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        int i;
        StringBuilder firstString = new StringBuilder();
        firstString.append(list.get(0));
        for (i = 1; i < list.size(); i++) {
            try {
                int number = Integer.parseInt(list.get(i));
                String stringToCopy = firstString.toString();
                firstString.insert(number + 1, stringToCopy);
            } catch (NumberFormatException e) {
                break;
            }
        }

        StringBuilder secondString = new StringBuilder();
        secondString.append(list.get(i));
        i++;
        for (; i < list.size(); i++) {
            try {
                int number = Integer.parseInt(list.get(i));
                String stringToCopy = secondString.toString();
                secondString.insert(number + 1, stringToCopy);
            } catch (NumberFormatException e) {
                break;
            }
        }

        outputList.add(firstString);
        outputList.add(secondString);
        return outputList;
    }
}
package main.java.com.pb.sequenceAligner.evaluator;

import main.java.com.pb.sequenceAligner.aligner.BasicSequenceAligner;
import main.java.com.pb.sequenceAligner.aligner.DivideAndConquerSequenceAligner;
import main.java.com.pb.sequenceAligner.input.StringGenerator;
import main.java.com.pb.sequenceAligner.parameters.AlignmentParameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Evaluator {
    public static void main(String args[]) throws IOException {

        String filePath = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "pb" + File.separator + "sequenceAligner" + File.separator + "input_Evaluator" + File.separator + "input.txt";
        List<StringBuilder> inputStrings = StringGenerator.readFromInputFile(filePath);

        String firstString = inputStrings.get(0).toString();
        String secondString = inputStrings.get(1).toString();

        String outputFilePathBasic = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "pb" + File.separator + "sequenceAligner" + File.separator + "output_Evaluator" + File.separator + "output_Basic.txt";
        FileWriter basicVersionFileWriter = new FileWriter(outputFilePathBasic);
        long startTimeForBasicVersion = System.currentTimeMillis();
        long beforeUsedMemForBasicVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        AlignmentParameters basicAlignmentParameters = BasicSequenceAligner.execute(firstString, secondString);
        long endTimeForBasicVersion = System.currentTimeMillis();
        long afterUsedMemForBasicVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (basicAlignmentParameters.getFirstAlignedString().length() < 50) {
            basicVersionFileWriter.write(basicAlignmentParameters.getFirstAlignedString());
            basicVersionFileWriter.write(" ");
            basicVersionFileWriter.write(basicAlignmentParameters.getFirstAlignedString());
            basicVersionFileWriter.write("\n");
            basicVersionFileWriter.write(basicAlignmentParameters.getSecondAlignedString());
            basicVersionFileWriter.write(" ");
            basicVersionFileWriter.write(basicAlignmentParameters.getSecondAlignedString());
            basicVersionFileWriter.write("\n");
        } else {
            basicVersionFileWriter.write(basicAlignmentParameters.getFirstAlignedString().substring(0, 51));
            basicVersionFileWriter.write(" ");
            basicVersionFileWriter.write(basicAlignmentParameters.getFirstAlignedString().substring(basicAlignmentParameters.getFirstAlignedString().length() - 50));
            basicVersionFileWriter.write("\n");
            basicVersionFileWriter.write(basicAlignmentParameters.getSecondAlignedString().substring(0, 51));
            basicVersionFileWriter.write(" ");
            basicVersionFileWriter.write(basicAlignmentParameters.getSecondAlignedString().substring(basicAlignmentParameters.getSecondAlignedString().length() - 50));
            basicVersionFileWriter.write("\n");
        }

        basicVersionFileWriter.write(basicAlignmentParameters.getAlignmentCost() + "\n");
        basicVersionFileWriter.write((endTimeForBasicVersion - startTimeForBasicVersion) / 1000F + "\n");
        basicVersionFileWriter.write((afterUsedMemForBasicVersion - beforeUsedMemForBasicVersion) / 1024 + "\n");

        basicVersionFileWriter.close();


        System.out.println("-----------------------");


        String outputFilePathDC = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "pb" + File.separator + "sequenceAligner" + File.separator + "output_Evaluator" + File.separator + "output_DivideAndConquer.txt";
        FileWriter DCVersionFileWriter = new FileWriter(outputFilePathDC);
        long startTimeForDivideAndConquerVersion = System.currentTimeMillis();
        long beforeUsedMemForDivideAndConquerVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        AlignmentParameters DCAlignmentParameters = DivideAndConquerSequenceAligner.execute(firstString, secondString);
        long endTimeForDivideAndConquerVersion = System.currentTimeMillis();
        long afterUsedMemForDivideAndConquerVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        if (DCAlignmentParameters.getFirstAlignedString().length() < 50) {
            DCVersionFileWriter.write(DCAlignmentParameters.getFirstAlignedString());
            DCVersionFileWriter.write(" ");
            DCVersionFileWriter.write(DCAlignmentParameters.getFirstAlignedString());
            DCVersionFileWriter.write("\n");
            DCVersionFileWriter.write(DCAlignmentParameters.getSecondAlignedString());
            DCVersionFileWriter.write(" ");
            DCVersionFileWriter.write(DCAlignmentParameters.getSecondAlignedString());
            DCVersionFileWriter.write("\n");
        } else {
            DCVersionFileWriter.write(DCAlignmentParameters.getFirstAlignedString().substring(0, 51));
            DCVersionFileWriter.write(" ");
            DCVersionFileWriter.write(DCAlignmentParameters.getFirstAlignedString().substring(DCAlignmentParameters.getFirstAlignedString().length() - 50));
            DCVersionFileWriter.write("\n");
            DCVersionFileWriter.write(DCAlignmentParameters.getSecondAlignedString().substring(0, 51));
            DCVersionFileWriter.write(" ");
            DCVersionFileWriter.write(DCAlignmentParameters.getSecondAlignedString().substring(DCAlignmentParameters.getSecondAlignedString().length() - 50));
            DCVersionFileWriter.write("\n");
        }

        DCVersionFileWriter.write(DCAlignmentParameters.getAlignmentCost() + "\n");
        DCVersionFileWriter.write((endTimeForDivideAndConquerVersion - startTimeForDivideAndConquerVersion) / 1000F + "\n");
        DCVersionFileWriter.write((afterUsedMemForDivideAndConquerVersion - beforeUsedMemForDivideAndConquerVersion) / 1024 + "\n");

        DCVersionFileWriter.close();


        System.out.println("-----------------------");

    }
}

package main.java.com.pb.sequenceAligner.evaluator;

import main.java.com.pb.sequenceAligner.aligner.BasicSequenceAligner;
import main.java.com.pb.sequenceAligner.aligner.DivideAndConquerSequenceAligner;
import main.java.com.pb.sequenceAligner.input.StringGenerator;
import main.java.com.pb.sequenceAligner.parameters.AlignmentParameters;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GraphEvaluator {
    public static void main(String args[]) throws IOException {

        String folderPath = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "pb" + File.separator + "sequenceAligner" + File.separator + "input_graphEvaluator";
        final File folder = new File(folderPath);

        for (final File fileEntry : folder.listFiles()) {


            List<StringBuilder> inputStrings = StringGenerator.readFromInputFile(fileEntry.getCanonicalPath());

            String firstString = inputStrings.get(0).toString();
            String secondString = inputStrings.get(1).toString();

            long startTimeForBasicVersion = System.currentTimeMillis();
            long beforeUsedMemForBasicVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            AlignmentParameters basicAlignmentParameters = BasicSequenceAligner.execute(firstString, secondString);
            long endTimeForBasicVersion = System.currentTimeMillis();
            long afterUsedMemForBasicVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();


            System.out.print(fileEntry.getName() + "," + (firstString.length() + secondString.length()) + "," + basicAlignmentParameters.getAlignmentCost() + "," + (endTimeForBasicVersion - startTimeForBasicVersion) / 1000F + "," + (afterUsedMemForBasicVersion - beforeUsedMemForBasicVersion) / 1024 + "\n");

            long startTimeForDivideAndConquerVersion = System.currentTimeMillis();
            long beforeUsedMemForDivideAndConquerVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            AlignmentParameters DCAlignmentParameters = DivideAndConquerSequenceAligner.execute(firstString, secondString);
            long endTimeForDivideAndConquerVersion = System.currentTimeMillis();
            long afterUsedMemForDivideAndConquerVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            System.out.print(fileEntry.getName() + "," + (firstString.length() + secondString.length()) + "," + DCAlignmentParameters.getAlignmentCost() + "," + (endTimeForDivideAndConquerVersion - startTimeForDivideAndConquerVersion) / 1000F + "," + (afterUsedMemForDivideAndConquerVersion - beforeUsedMemForDivideAndConquerVersion) / 1024 + "\n");
        }
    }
}

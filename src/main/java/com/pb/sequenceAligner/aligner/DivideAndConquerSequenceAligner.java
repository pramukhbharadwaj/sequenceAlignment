package main.java.com.pb.sequenceAligner.aligner;

import main.java.com.pb.sequenceAligner.parameters.AlignmentParameters;

public class DivideAndConquerSequenceAligner {

    public static void main(String[] args) {
        long beforeUsedMemForDivideAndConquerVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimeForDivideAndConquerVersion = System.currentTimeMillis();
        AlignmentParameters parameters = execute("AGAGAAGAGAGAGAGAAGAGAGAAGAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTC",
                "TATATATATATTATATATATATATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTATATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTATATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGC");
        long endTimeForDivideAndConquerVersion = System.currentTimeMillis();
        //System.out.println(main.java.com.pb.sequenceAligner.parameters.getFirstAlignedString());
        //System.out.println(main.java.com.pb.sequenceAligner.parameters.getSecondAlignedString());
        long afterUsedMemForDivideAndConquerVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println((endTimeForDivideAndConquerVersion - startTimeForDivideAndConquerVersion) / 1000F + "\n");
        System.out.println((afterUsedMemForDivideAndConquerVersion - beforeUsedMemForDivideAndConquerVersion) / 1024 + "\n");
        System.out.println(parameters.getAlignmentCost());
    }

    public static AlignmentParameters execute(String firstString, String secondString) {
        AlignmentParameters parameters = divideAndConquerSequenceAligner(firstString, secondString);
        parameters.setAlignmentCost(getAlignmentCost(parameters.getFirstAlignedString(), parameters.getSecondAlignedString()));
        return parameters;
    }

    private static AlignmentParameters divideAndConquerSequenceAligner(String first, String second) {

        if (first.length() <= 2 || second.length() <= 2)
            return getAlignmentParameters(first, second);

        int midOfFirstString = first.length() / 2;

        int[][] leftAlignmentDPValues = BasicSequenceAligner.spaceEfficientBasicSequenceAligner(first.substring(0, midOfFirstString), second);
        int[][] rightAlignmentDPValues = BasicSequenceAligner.spaceEfficientBasicSequenceAligner(new StringBuffer(first.substring(midOfFirstString)).reverse().toString(), new StringBuffer(second).reverse().toString());
        int index = findOptimalBreakingPoint(leftAlignmentDPValues, rightAlignmentDPValues);

        AlignmentParameters leftAlignment = divideAndConquerSequenceAligner(first.substring(0, midOfFirstString), second.substring(0, index));
        AlignmentParameters rightAlignment = divideAndConquerSequenceAligner(first.substring(midOfFirstString), second.substring(index));

        return new AlignmentParameters(leftAlignment.getFirstAlignedString() + rightAlignment.getFirstAlignedString(), leftAlignment.getSecondAlignedString() + rightAlignment.getSecondAlignedString());
    }

    private static int getAlignmentCost(String firstString, String secondString) {
        int cost = 0;
        for (int i = 0; i < firstString.length(); i++) {
            if (firstString.charAt(i) == secondString.charAt(i)) {

            } else if (firstString.charAt(i) == '_' || secondString.charAt(i) == '_') {
                cost = cost + BasicSequenceAligner.gapPenalty;
            } else {
                cost = cost + BasicSequenceAligner.getMismatchCost(firstString.charAt(i), secondString.charAt(i));
            }
        }

        return cost;
    }

    private static AlignmentParameters getAlignmentParameters(String first, String second) {
        return BasicSequenceAligner.getAlignmentParameters(BasicSequenceAligner.basicSequenceAligner(first, second), first, second);
    }

    private static int findOptimalBreakingPoint(int[][] leftDP, int[][] rightDP) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for (int k = 0; k < leftDP[0].length; k++) {
            if (leftDP[0][k] + rightDP[0][rightDP[0].length - 1 - k] < minValue) {
                minValue = leftDP[0][k] + rightDP[0][rightDP[0].length - 1 - k];
                minIndex = k;
            }
        }
        return minIndex;
    }
}

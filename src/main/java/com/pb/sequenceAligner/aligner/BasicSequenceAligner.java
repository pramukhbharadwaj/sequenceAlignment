package main.java.com.pb.sequenceAligner.aligner;

import main.java.com.pb.sequenceAligner.parameters.AlignmentParameters;

public class BasicSequenceAligner {

    public static final int gapPenalty = 30;

    public static void main(String args[]) {
        long beforeUsedMemForBasicVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTimeForBasicVersion = System.currentTimeMillis();
        AlignmentParameters parameters = execute("AGAGAAGAGAGAGAGAAGAGAGAAGAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAGTCAGAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCAAGTCAGTCAGTCAGTCGTCAGTCAGTCTCAAGTCAGTCAGTCAGTCGTCAGTCAGTC",
                "TATATATATATTATATATATATATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTATATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTATATTATATATATTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATATATTTATTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGCTTATAGCGCAGCGCATAGCGCAGCGCTTTATTATAGCGCAGCGCATAGCGCAGCGC");
        long endTimeForBasicVersion = System.currentTimeMillis();
        long afterUsedMemForBasicVersion = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        //System.out.println(main.java.com.pb.sequenceAligner.parameters.getFirstAlignedString());
        //System.out.println(main.java.com.pb.sequenceAligner.parameters.getSecondAlignedString());
        System.out.println((endTimeForBasicVersion - startTimeForBasicVersion) / 1000F + "\n");
        System.out.println((afterUsedMemForBasicVersion - beforeUsedMemForBasicVersion) / 1024 + "\n");
        System.out.println(parameters.getAlignmentCost());
    }

    public static AlignmentParameters execute(String firstString, String secondString) {
        AlignmentParameters parameters = getAlignmentParameters(basicSequenceAligner(firstString, secondString), firstString, secondString);
        return parameters;
    }

    public static int[][] spaceEfficientBasicSequenceAligner(String firstString, String secondString) {
        char[] first = firstString.toCharArray();
        int m = first.length;
        char[] second = secondString.toCharArray();
        int n = second.length;

        int dp[][] = new int[2][n + 1];

        // initialise base cases
        for (int j = 0; j < n + 1; j++)
            dp[0][j] = j * gapPenalty;

        for (int i = 1; i < m + 1; i++) {
            dp[1][0] = i * gapPenalty;
            for (int j = 1; j < n + 1; j++) {
                dp[1][j] = Math.min(dp[0][j - 1] + getMismatchCost(first[i - 1], second[j - 1]), Math.min(dp[0][j] + gapPenalty, dp[1][j - 1] + gapPenalty));
            }

            for (int k = 0; k < n + 1; k++) {
                dp[0][k] = dp[1][k];
                dp[1][k] = 0;
            }
        }

        return dp;
    }

    public static int[][] basicSequenceAligner(String firstString, String secondString) {

        char[] first = firstString.toCharArray();
        int m = first.length;
        char[] second = secondString.toCharArray();
        int n = second.length;


        int dp[][] = new int[m + 1][n + 1];

        // initialise base cases
        for (int j = 0; j < n + 1; j++)
            dp[0][j] = j * gapPenalty;
        for (int i = 0; i < m + 1; i++)
            dp[i][0] = i * gapPenalty;


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + getMismatchCost(first[i - 1], second[j - 1]), Math.min(dp[i - 1][j] + gapPenalty, dp[i][j - 1] + gapPenalty));
            }
        }
        return dp;
    }

    public static AlignmentParameters getAlignmentParameters(int[][] dp, String firstString, String secondString) {
        char[] first = firstString.toCharArray();
        char[] second = secondString.toCharArray();
        int gapPenalty = 30;

        StringBuilder builderFirstString = new StringBuilder();
        StringBuilder builderSecondString = new StringBuilder();

        int i, j;
        for (i = dp.length - 1, j = dp[0].length - 1; i > 0 && j > 0; ) {
            if (dp[i - 1][j - 1] + getMismatchCost(first[i - 1], second[j - 1]) <= dp[i - 1][j] + gapPenalty && dp[i - 1][j - 1] + getMismatchCost(first[i - 1], second[j - 1]) <= dp[i][j - 1] + gapPenalty) {
                builderFirstString.append(first[i - 1]);
                builderSecondString.append(second[j - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] + gapPenalty < dp[i - 1][j - 1] + getMismatchCost(first[i - 1], second[j - 1]) && (dp[i - 1][j] + gapPenalty < dp[i][j - 1] + gapPenalty)) {
                builderFirstString.append(first[i - 1]);
                builderSecondString.append("_");
                i--;
            } else {
                builderFirstString.append("_");
                builderSecondString.append(second[j - 1]);
                j--;
            }

        }

        while (i > 0) {
            builderFirstString.append(first[i - 1]);
            builderSecondString.append("_");
            i--;
        }

        while (j > 0) {
            builderFirstString.append("_");
            builderSecondString.append(second[j - 1]);
            j--;
        }


        return new AlignmentParameters(builderFirstString.reverse().toString(), builderSecondString.reverse().toString(), dp[firstString.length()][secondString.length()]);
    }

    public static int getMismatchCost(char c1, char c2) {
        int mismatchPenalty[][] = {{0, 110, 48, 94}, {110, 0, 118, 48}, {48, 118, 0, 110}, {94, 48, 110, 0}};
        int k, h;
        if (c1 == 'A')
            k = 0;
        else if (c1 == 'C')
            k = 1;
        else if (c1 == 'G')
            k = 2;
        else
            k = 3;

        if (c2 == 'A')
            h = 0;
        else if (c2 == 'C')
            h = 1;
        else if (c2 == 'G')
            h = 2;
        else
            h = 3;

        return mismatchPenalty[k][h];
    }
}

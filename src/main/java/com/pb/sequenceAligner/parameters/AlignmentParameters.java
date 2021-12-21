package main.java.com.pb.sequenceAligner.parameters;

public class AlignmentParameters {
    String firstAlignedString;
    String secondAlignedString;
    int alignmentCost;

    public AlignmentParameters(String firstAlignedString, String secondAlignedString) {
        this.firstAlignedString = firstAlignedString;
        this.secondAlignedString = secondAlignedString;
    }

    public AlignmentParameters(String firstAlignedString, String secondAlignedString, int alignmentCost) {
        this.firstAlignedString = firstAlignedString;
        this.secondAlignedString = secondAlignedString;
        this.alignmentCost = alignmentCost;
    }

    public String getFirstAlignedString() {
        return firstAlignedString;
    }

    public void setFirstAlignedString(String firstAlignedString) {
        this.firstAlignedString = firstAlignedString;
    }

    public String getSecondAlignedString() {
        return secondAlignedString;
    }

    public void setSecondAlignedString(String secondAlignedString) {
        this.secondAlignedString = secondAlignedString;
    }

    public int getAlignmentCost() {
        return alignmentCost;
    }

    public void setAlignmentCost(int alignmentCost) {
        this.alignmentCost = alignmentCost;
    }
}
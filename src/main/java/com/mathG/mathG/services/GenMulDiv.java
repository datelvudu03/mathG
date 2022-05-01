package com.mathG.mathG.services;

import java.util.Random;

public class GenMulDiv {
    private String operation;
    private final Random random = new Random();
    private final String[][] allowedOperation = {{"mul","*"},{"div","÷"}};
    private String[] problems = new String[10];
    private String[][] listOfProblems = new String[10][3];

    public void createMulDivProblem(int multiplyBy){
        String operationIn;
        int result;
        if (operation == null || !(operation.equals("*") || operation.equals("÷"))){
            operationIn = (random.nextInt(2) == 0)? "*" : "÷";
        }else {
            operationIn = operation;
        }
        for (int i = 1; i < 11;i++){
            result = i * multiplyBy;
            listOfProblems[i-1][0] = String.valueOf(i);
            listOfProblems[i-1][1] = String.valueOf(multiplyBy);
            listOfProblems[i-1][2] = String.valueOf(result);
        }
        if (operationIn.equals("*")){
            for (int i = 0; i < 10; i++) {
                problems[i] = listOfProblems[i][0] + " " + operationIn + " " + listOfProblems[i][1] + " = ...";
            }
        }else {
            for (int i = 0; i < 10; i++) {
                problems[i] = listOfProblems[i][2] + " " + operationIn + " " + listOfProblems[i][1] + " = ...";
            }
        }
    }


    public void setOperation(String operation) {
        for(String[] a: allowedOperation) {
            if(a[0].equalsIgnoreCase(operation)) {
                operation = a[1];
            }
        }
        this.operation = operation;
    }

    public String[] getProblems() {
        return problems;
    }
}

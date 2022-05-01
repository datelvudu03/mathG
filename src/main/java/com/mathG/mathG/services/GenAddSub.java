package com.mathG.mathG.services;

import java.util.Random;

public class GenAddSub {
    private String problem,operation;
    private String[] formula = new String[4];
    private final Random random = new Random();
    private final String[][] allowedOperation = {{"plus","+"},{"minus","-"}};

    public String getProblem() {
        return problem;
    }
    public void createAddSubProblem(int upToo){
        int number1, number2, result;
        String theProblem,operationIn;
        if (operation == null || !(operation.equals("+") || operation.equals("-"))){
            operationIn = (random.nextInt(2) == 0)? "+" : "-";
        }else {
            operationIn = operation;
        }

        //
        number1 = betterRandom(upToo);
        if(operationIn.equals("+")){
            number2 = betterRandom(upToo-number1);
            result = number1 + number2;
        }else {
            number2 = betterRandom(number1+1);
            result = number1 - number2;
        }
        formula[0] = String.valueOf(number1);
        formula[1] = String.valueOf(number2);
        formula[2] = String.valueOf(result);
        formula[3] = operationIn;
        theProblem = number1 +" "+ operationIn +" "+ number2 + " = ...";
        problem = theProblem;
    }

    /*
     * public void createAddSubProblemInverted(int upToo ){ int number1, number2,
     * result; String theProblem,operationIn; boolean position = random.nextInt(2)
     * == 0;
     *
     * if (operation == null || !(operation.equals("+") || operation.equals("-"))){
     * operationIn = (random.nextInt(2) == 0)? "+" : "-"; }else { operationIn =
     * operation;
     *
     * }
     *
     * //operation = (random.nextInt(2) == 0)? "+" : "-"; number1 =
     * betterRandom(upToo); if(operationIn.equals("+")){ number2 =
     * betterRandom(upToo-number1); result = number1 + number2; theProblem =
     * (position)? result+" = "+number1+" + ..." : result+" = "+"..."+" + "+number2
     * ; }else { number2 = betterRandom(number1+1); result = number1 - number2;
     * theProblem = (position)? result+" = "+number1+" - ..." :
     * result+" = "+"..."+" - "+number2 ; }
     *
     * problem = theProblem; }
     */
    public void mixPosition(int upToo,int position){

        createAddSubProblem(upToo);
        if(position < 0 || position > 2) {
            position = random.nextInt(3);
        }
        switch (position) {
            case 0: problem = "... " + formula[3] + " " + formula[1] + " = " + formula[2];
                break;
            case 1: problem = formula[0] + " " + formula[3] + " ... = " + formula[2];
                break;
            case 2: problem = formula[0] + " " + formula[3] + " " + formula[1] + " = ...";
                break;
        }
    }
    private int betterRandom(int upToo){
        double dNumber;
        int chance,number;
        do {
            number = random.nextInt(upToo+1);
            chance = random.nextInt(9);
            if (chance == 4){
                break;
            }
            dNumber = (double) number/(double) upToo;
        }while (dNumber < 0.1 || dNumber > 0.9);
        return number;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        for(String[] a: allowedOperation) {
            if(a[0].equalsIgnoreCase(operation)) {
                operation = a[1];
            }
        }
        this.operation = operation;
    }
}

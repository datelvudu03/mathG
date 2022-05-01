package com.mathG.mathG.controller;

import com.mathG.mathG.model.Exercise;
import com.mathG.mathG.services.GenAddSub;
import com.mathG.mathG.services.GenMulDiv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ExerciseController {
    private final ArrayList<String> exerciseList = new ArrayList<String>();
    GenAddSub genAddSub = new GenAddSub();
    GenMulDiv genMulDiv = new GenMulDiv();

    //http://localhost:8080/exercise/AddSub
    //http://localhost:8080/exercise/AddSub?operation=plus
    //http://localhost:8080/exercise/AddSub?operation=plus&upToo=100
    @GetMapping("/exercise/AddSub")
    public Exercise exerciseAddSub(@RequestParam(name = "operation", defaultValue = "") String operation,
                                   @RequestParam(name = "upToo",defaultValue = "20")int upToo,
                                   @RequestParam(name = "amount",defaultValue = "20")int amountOfExercise){
        if(amountOfExercise > 100) {
            amountOfExercise = 100;
        }
        genAddSub.setOperation(operation);

        ArrayList<String> temp = new ArrayList<String>();
        for(int i = 0; i < amountOfExercise; i++ ) {
            genAddSub.createAddSubProblem(upToo);
            temp.add(genAddSub.getProblem());
        }

        return new Exercise(temp);
    }
    //http://localhost:8080/exercise/AddSubMix?operation=mul
    @GetMapping("/exercise/AddSubMix")
    public Exercise exerciseAddSubMix(@RequestParam(name = "operation", defaultValue = "") String operation,
                                      @RequestParam(name = "upToo",defaultValue = "20")int upToo,
                                      @RequestParam(name = "amount",defaultValue = "20")int amountOfExercise,
                                      @RequestParam(name = "position",defaultValue = "3")int position) {
        ArrayList<String> temp = new ArrayList<String>();
        genAddSub.setOperation(operation);
        if(amountOfExercise > 100) {
            amountOfExercise = 100;
        }
        for(int i = 0; i < amountOfExercise; i++ ) {
            genAddSub.mixPosition(upToo,position);
            temp.add(genAddSub.getProblem());
        }

        return new Exercise(temp);
    }

    @GetMapping("/exercise/genMulDiv")
    public Exercise exerciseGenMulDiv(@RequestParam(name = "operation", defaultValue = "") String operation,
                                       //@RequestParam(name = "multiplyBy",defaultValue = "20")int multiplyBy,
                                       @RequestParam(name = "multiplyBy",defaultValue = "") List<Integer> multiplyBy,
                                       @RequestParam (name = "mix",defaultValue = "false") boolean mix,
                                       @RequestParam(name = "amount",defaultValue = "20")int amountOfExercise) {

        ArrayList<String> temp = new ArrayList<String>();
        if(amountOfExercise > 100) {
            amountOfExercise = 100;
        }

        for(int i: multiplyBy) {
            genMulDiv.setOperation(operation);
            genMulDiv.createMulDivProblem(i);
            for(String a: genMulDiv.getProblems()) {
                temp.add(a);
            }
        }
        if(mix) {
            Collections.shuffle(temp);
        }
        return new Exercise(temp);
    }

    @GetMapping("/exercise/all")
    public Exercise exerciseAll() {
        return new Exercise(exerciseList);
    }
}

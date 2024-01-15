package com.example.Computers.Patterns.Plateau;

import java.util.ArrayList;
import java.util.List;

import com.example.Constants.States;

public class PlateauStatescomputer 
{
    public List<String> computeState(List<String> signature)
    {
        List<String> states = new ArrayList<>();
        String last = States.s;
        states.add(last);

        for (String ch : signature) {
            String state;
            if(last == States.s){
                if(ch == "<"){
                    state = States.r;
                }
                else{
                    state = States.s;
                }
            }
            else if(last == States.r){
                if(ch == ">"){
                    state = States.s;
                }
                else if(ch == "="){
                    state = States.t;
                }
                else{
                    state = States.r;
                }
            }
            else{
                if(ch == "<"){
                    state = States.r;
                }
                else if(ch == "="){
                    state = States.t;
                }
                else{
                    state = States.s;
                }
            }

            states.add(state);
            last = state;
        }

        return states;
    }
}

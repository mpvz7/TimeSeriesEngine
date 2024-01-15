package com.example.Computers.Patterns.Peak;

import java.util.ArrayList;
import java.util.List;

import com.example.Constants.Semantics;
import com.example.Constants.States;

public class PeakSemanticsComputer {

    private PeakStatesComputer _peakStatesComputer = new PeakStatesComputer();

    public List<String> ComputeSemantics(List<String> signature)
    {
        List<String>  states = _peakStatesComputer.computeState(signature);

        List<String> semantics = new ArrayList<>();

        for (int i = 0; i < signature.size(); i++)
        {
           String semantic;
           String actualS = signature.get(i);
           String state1 = states.get(i);

           if(state1 == States.s){
                semantic = Semantics.out;
           }
           else if(state1 == States.r){
                if(actualS == ">"){
                    semantic = Semantics.found;
                }
                else{
                    semantic = Semantics.maybeB;
                }
           }
           else{
                if(actualS == ">"){
                    semantic = Semantics.in;
                }
                else if(actualS == "="){
                    semantic = Semantics.maybeA;
                }
                else{
                    semantic = Semantics.outA;
                }
           }

           semantics.add(semantic);
        }

        return semantics;
    }
}

package com.example.Computers.Patterns.Plateau;

import java.util.ArrayList;
import java.util.List;

import com.example.Constants.Semantics;
import com.example.Constants.States;

public class PlateauSemanticsComputer 
{
    private PlateauStatescomputer _plateauStatescomputer = new PlateauStatescomputer();

    public List<String> ComputeSemantics(List<String> signature)
    {
        List<String>  states = _plateauStatescomputer.computeState(signature);

        List<String> semantics = new ArrayList<>();

        for (int i = 0; i < signature.size(); i++)
        {
            String semantic;
            String actualS = signature.get(i);
            String state1 = states.get(i);

            if(state1 == States.s)
            {
                semantic = Semantics.out;
            }
            else if(state1 == States.r)
            {
                if(actualS == ">"){
                    semantic = Semantics.foundE;
                }
                else if(actualS == "<"){
                    semantic = Semantics.out;
                }
                else{
                    semantic = Semantics.maybeB;
                }
            }
            else{
                if(actualS == ">"){
                    semantic = Semantics.foundE;
                }
                else if(actualS == "="){
                    semantic = Semantics.maybeB;
                }
                else{
                    semantic = Semantics.outR;
                }
            }

            semantics.add(semantic);
        }

        return semantics;
    }
}

package com.example.Computers.Patterns.Steady;

import java.util.ArrayList;
import java.util.List;

import com.example.Constants.Semantics;

public class SteadySemanticsComputer
{
    public List<String> ComputeSemantics(List<String> signature)
    {
        List<String> semantics = new ArrayList<>();

        for (int i = 0; i < signature.size(); i++)
        {
           String semantic;
           String actualS = signature.get(i);

           if(actualS == "=")
           {
                semantic =Semantics.foundE;
           }
           else
           {
                semantic =Semantics.out;
           }

           semantics.add(semantic);
        }

        return semantics;
    }
}

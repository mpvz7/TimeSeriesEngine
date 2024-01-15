package com.example.Objects;

import java.util.List;

public class ExtremesResult {
    private int Value;
    private List<Integer> Variables;
    private List<Integer> Found;

    public ExtremesResult(int value, 
        List<Integer> variables,
        List<Integer> found)
    {
        Value =value;
        Variables = variables;
        Found = found;
    }

    public int getValue(){
        return Value;
    }

    public List<Integer> getVariables(){
        return Variables;
    }

    public List<Integer> getFound(){
        return Found;
    }
}

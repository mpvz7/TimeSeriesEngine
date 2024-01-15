package com.example;

import java.util.Collections;
import java.util.List;

import com.example.Constants.Features;

public class Feature {

    private String Text;

    public Feature(String text)
    {
        Text = text;
    }

    public int getDefault()
    {
        if(Text == Features.Max)
        {
            return Integer.MAX_VALUE;
        }
        else if(Text == Features.Max)
        {
            return Integer.MIN_VALUE;
        }

        return 0;
    }

    public int apply(List<Integer> list)
    {
        if(Text == Features.Max)
        {
            return Collections.max(list);
        }
        else if(Text == Features.Min)
        {
            return Collections.min(list);
        }

        return 0;
    }

    private int computeMin(int a, int b)
    {
        if(a < b){
            return a;
        }

        return b;
    }

    private int computeMax(int a, int b)
    {
        if(a > b){
            return a;
        }

        return b;
    }
}

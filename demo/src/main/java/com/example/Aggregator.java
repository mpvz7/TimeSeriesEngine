package com.example;

import com.example.Constants.Aggregators;

public class Aggregator 
{
    private String Text;

    public Aggregator(String text)
    {
        Text = text;
    }

    public boolean isAgg(int a, int b)
    {
        if(Text == Aggregators.Max)
        {
            return isBigger(a, b);
        }
        else if(Text == Aggregators.Min)
        {
            return isSmaller(a, b);
        }

        return false;
    }

    public int getDefault()
    {
        if(Text == Aggregators.Min)
        {
            return Integer.MAX_VALUE;
        }
        else if(Text == Aggregators.Max)
        {
            return Integer.MIN_VALUE;
        }

        return 0;
    }

    public int apply(int a, int b)
    {
        if(Text == Aggregators.Max)
        {
            return computeMax(a, b);
        }
        else if(Text == Aggregators.Min)
        {
            return computeMin(a, b);
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

    private boolean isBigger(int a, int b)
    {
        if(a < b){
            return false;
        }

        return true;
    }

    private boolean isSmaller(int a, int b)
    {
        if(a > b){
            return false;
        }

        return true;
    }
}

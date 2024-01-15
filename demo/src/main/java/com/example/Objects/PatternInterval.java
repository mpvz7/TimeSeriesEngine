package com.example.Objects;

public class PatternInterval
{
    private int Start;
    private int End;
    private int FeatureValue;
    private int FeatureIndex;

    public PatternInterval(int start, int end){
        Start = start;
        End = end;
    }

    public int getStart(){
        return Start;
    }

    public int getEnd(){
        return End;
    }

    public int getFeatureValue(){
        return FeatureValue;
    }

    public int getFeatureIndex(){
        return FeatureIndex;
    }

    public void SetFeatureValue(int value){
        this.FeatureValue = value;
    }

    public void SetFeatureIndex(int index){
        this.FeatureIndex = index;
    }
}

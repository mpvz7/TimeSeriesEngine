package com.example.Computers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Objects.PatternInterval;

public class FoundBuilder
{
    public List<Integer> buildFound(
        List<PatternInterval> intervals,
        int size,
        int value)
    {
        List<Integer> found = new ArrayList<>(Collections.nCopies(size, 0));

        for (PatternInterval interval : intervals) 
        {
            Integer featureValue = interval.getFeatureValue();

            if(featureValue == value)
            {
                Integer index = interval.getFeatureIndex();
                found.set(index, 1);
            }
        }

        return found;
    }
}

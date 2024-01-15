package com.example.Computers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Constants.Aggregators;
import com.example.Objects.PatternInterval;

public class AggregatorComputer 
{
    public Integer computeAggregator(
        String aggregator,
        List<PatternInterval> intervals)
    {
        String lowerCaseaggregator = aggregator.toLowerCase();
        if(lowerCaseaggregator == Aggregators.Max)
        {
            return computeMaximums(intervals);
        }
        else if(lowerCaseaggregator == Aggregators.Min)
        {
            return computeMinimums(intervals);
        }
        else
        {
            return 0; // On ne passe jamais ici
        }
    }

    private Integer computeMaximums(
        List<PatternInterval> intervals)
    {
       List<Integer> featurevalues = getfeatureValues(intervals);

       return Collections.max(featurevalues);
    }

    private Integer computeMinimums(
        List<PatternInterval> intervals)
    {
       List<Integer> featurevalues = getfeatureValues(intervals);

       return Collections.min(featurevalues);
    }

    private List<Integer> getfeatureValues(List<PatternInterval> intervals)
    {
        List<Integer> results = new ArrayList<Integer>();

        for (PatternInterval interval : intervals) 
        {
            Integer featurevalue = interval.getFeatureValue();

            results.add(featurevalue);
        }

        return results;
    }
}

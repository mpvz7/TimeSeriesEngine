package com.example.Computers;

import java.util.List;

import com.example.Constants.Features;
import com.example.Objects.PatternInterval;

public class FeatureComputer 
{
    public void computeFeature(
        String feature,
        List<PatternInterval> intervals,
        List<Integer> variables)
    {
        String lowerCasefeature = feature.toLowerCase();
        if(lowerCasefeature == Features.Max)
        {
            computeMaximums(intervals, variables);
        }
        else if(lowerCasefeature == Features.Min)
        {
            computeMinimums(intervals, variables);
        }
    }

    private void computeMaximums(
        List<PatternInterval> intervals,
        List<Integer> variables)
    {
        for (PatternInterval interval : intervals) 
        {
            int start = interval.getStart();
            int end = interval.getEnd();
            List<Integer> subList = variables.subList(start, end+1);

            findMaximumValueWithIndex(subList, interval);
        }
    }

    private void computeMinimums(
        List<PatternInterval> intervals,
        List<Integer> variables)
    {
        for (PatternInterval interval : intervals) 
        {
            int start = interval.getStart();
            int end = interval.getEnd();
            List<Integer> subList = variables.subList(start, end);

            findMinimumValueWithIndex(subList, interval);
        }
    }

    private void findMinimumValueWithIndex(
        List<Integer> list, 
        PatternInterval interval)
    {
        int minIndex = 0;
        int minValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= minValue) {
                minValue = list.get(i);
                minIndex = i;
            }
        }

        interval.SetFeatureValue(minValue);
        interval.SetFeatureIndex(minIndex + interval.getStart());
    }

    private void findMaximumValueWithIndex(
        List<Integer> list, 
        PatternInterval interval)
    {
        int maxIndex = 0;
        int maxValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= maxValue) {
                maxValue = list.get(i);
                maxIndex = i;
            }
        }

        interval.SetFeatureValue(maxValue);
        interval.SetFeatureIndex(maxIndex + interval.getStart());
    }
}

package com.example.Constants;

import java.util.List;

public class Aggregators
{
    public static final String Max = "max";
    public static final String Min = "min";

    private static final List<String> AvailableAggregators = List.of(Max, Min);

    public static boolean IsAggregatorAvailable(String aggregator)
    {
        return AvailableAggregators.contains(aggregator.toLowerCase());
    }
}

package com.example.Constants;

import java.util.List;

public class Features 
{
    public static final String Max = "max";
    public static final String Min = "min";

    private static final List<String> AvailableFeatures = List.of(Max, Min);

    public static boolean IsFeatureAvailable(String feature)
    {
        return AvailableFeatures.contains(feature.toLowerCase());
    }
}

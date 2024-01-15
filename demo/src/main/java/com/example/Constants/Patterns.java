package com.example.Constants;

import java.util.List;

public class Patterns
{
    public static final String Increasing = "increasing";
    public static final String IncreasingSequence = "increasingsequence";
    public static final String IncreasingTerrace = "increasingterrace";
    public static final String Summit = "summit";
    public static final String Plateau = "plateau";
    public static final String ProperPlateau = "properplateau";
    public static final String StrictlyIncreasingSequence = "strictlyincreasingsequence";
    public static final String Peak = "peak";
    public static final String Inflexion = "inflexion";
    public static final String Steady = "steady";
    public static final String SteadySequence = "steadysequence";
    public static final String Zigzag = "zigzag";

    public static final String IncreasingRegularExpression = "<";
    public static final String IncreasingSequenceRegularExpression = "<(<|=)*<|<";
     public static final String IncreasingTerraceRegularExpression = "<=+<";
    public static final String SummitRegularExpression = "(<|(<(=|<)*<))(>|(>(=|>)*>))";
     public static final String PlateauRegularExpression = "<=*>";
    public static final String ProperPlateauRegularExpression = "<=+>";
     public static final String StrictlyIncreasingSequenceRegularExpression = "<+";
    public static final String PeakRegularExpression = "<(=|<)*(>|=)*>";
     public static final String InflexionRegularExpression = "<(<|=)*>|>(>|=)*<";
    public static final String SteadyRegularExpression = "=";
     public static final String SteadySequenceRegularExpression = "=+";
    public static final String ZigzagRegularExpression = "(<>)+(<|<>)|(><)+(>|><)";

    private static final List<String> AvailablePatterns = List.of(
        Increasing, 
        IncreasingSequence,
        IncreasingTerrace,
        Summit,
        Plateau, 
        ProperPlateau,
        StrictlyIncreasingSequence,
        Peak,
        Inflexion, 
        Steady,
        SteadySequence,
        Zigzag);

    public static boolean IsPatternAvailable(String pattern)
    {
        return AvailablePatterns.contains(pattern.toLowerCase());
    }

    public static String GetRegularExpression(String pattern)
    {
        switch(pattern.toLowerCase())
        {
            case Increasing:
                return IncreasingRegularExpression;
            case IncreasingSequence:
                return IncreasingSequenceRegularExpression;
            case IncreasingTerrace:
                return IncreasingTerraceRegularExpression;
            case Summit:
                return SummitRegularExpression;
            case Plateau:
                return PlateauRegularExpression;
            case ProperPlateau:
                return ProperPlateauRegularExpression;
            case StrictlyIncreasingSequence:
                return StrictlyIncreasingSequenceRegularExpression;
            case Peak:
                return PeakRegularExpression;
            case Inflexion:
                return InflexionRegularExpression;
            case Steady:
                return SteadyRegularExpression;
            case SteadySequence:
                return SteadySequenceRegularExpression;
            case Zigzag:
                return ZigzagRegularExpression;
            default:
            return null; // Patron non connu
        }
    }
}

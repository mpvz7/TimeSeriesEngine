package com.example.Computers;

import java.util.List;

import com.example.Computers.Patterns.PatternComputer;
import com.example.Computers.Patterns.SemanticsComputer;
import com.example.Constants.Aggregators;
import com.example.Constants.Features;
import com.example.Constants.Patterns;
import com.example.Decoration.DecorationTable;
import com.example.Objects.ExtremesResult;
import com.example.Objects.PatternInterval;

public class ExtremesComputer {
    
    private PatternComputer _patternComputer = new PatternComputer();
    private FeatureComputer _featureComputer = new FeatureComputer();
    private AggregatorComputer _aggregatorComputer = new AggregatorComputer();
    private FoundBuilder _foundBuilder = new FoundBuilder();

    private SemanticsComputer _semanticsComputer = new SemanticsComputer();
    private DecorationTable _decorationTable = new DecorationTable();

    // Calcul des extremes en utilisant du regex
    public ExtremesResult ComputeExtremes(
        String aggregator,
        String feature,
        String pattern,
        List<Integer> variables)
    {
        if(!Aggregators.IsAggregatorAvailable(aggregator)){
            System.out.println(String.format("L'aggregateur %s n'est pas couvert", aggregator));
            return null;
        }
        if(!Features.IsFeatureAvailable(feature)){
            System.out.println(String.format("Le feature %s n'est pas couvert", feature));
            return null;
        }
        if(!Patterns.IsPatternAvailable(pattern)){
            System.out.println(String.format("Le patron %s n'est pas couvert", pattern));
            return null;
        }

        List<PatternInterval> intervals = _patternComputer.computePatterns(pattern, variables); // trouver les occurences du patron
        _featureComputer.computeFeature(feature, intervals, variables); // Calculer le fauture pour chaque occurence
        Integer value = _aggregatorComputer.computeAggregator(aggregator, intervals); // Calculer l'aggregateur pour toutes les features

        List<Integer> found = _foundBuilder.buildFound(intervals, variables.size(), value); // Construire le vecteur du found

        return new ExtremesResult(value, variables, found);
    }

     // Calcul des extremes en utilisant du transducteur
    public ExtremesResult computeExtremes2(
        String aggregator,
        String feature,
        String pattern,
        List<Integer> variables)
    {
        List<String> semantics = _semanticsComputer.computeSemantics(variables, pattern);

        return _decorationTable.Decorate(aggregator, feature, variables, semantics);
    }
}

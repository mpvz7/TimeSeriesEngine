package com.example.Decoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Aggregator;
import com.example.Feature;
import com.example.Constants.Semantics;
import com.example.Objects.ExtremesResult;

public class DecorationTable {
    
    // On utilise la table de décoration 3.39 de type rFoundfoundE
    public ExtremesResult Decorate(
        String aggregator,
        String feature,
        List<Integer> variables, 
        List<String> semantics)
    {
        Integer size = variables.size();

        List<Integer> found = new ArrayList<>(Collections.nCopies(size, 0));
        
        Feature f = new Feature(feature);
        Aggregator agg = new Aggregator(aggregator);

        Integer defaultAgg = agg.getDefault(); // default(g, f)

        for (Integer i = 0; i < size - 1; i++) {
            String semantic = semantics.get(i);
            if(semantic == Semantics.found 
                || semantic == Semantics.foundE)
            {
                //Integer fValue = f.apply(variables.subList(i-before, i+after)); // Appliquer le feature
                List<Integer> patternOccurence = getPatternOccurence(i, semantics, variables);
                Integer fValue = f.apply(patternOccurence); // Appliquer le feature
                Integer aggValue = agg.apply(fValue, defaultAgg); // Appliquer l'aggregateur

                if(agg.isAgg(fValue, aggValue))
                {
                    found.set(i, 1);
                }

                defaultAgg = aggValue;
            }
        }

        return new ExtremesResult(defaultAgg, variables, found);
    }

    private List<Integer> getPatternOccurence(
        Integer i, 
        List<String> semantics,
        List<Integer>variables)
    {
        Integer size = semantics.size();
        Integer before = 0;
        Integer after = 1;
        String beforeSemantic = semantics.get(i-1);
        String afterSemantic = "";

        if(i+1 < size){
            afterSemantic = semantics.get(i+1);
        }
        

        while(beforeSemantic == Semantics.maybeB)
        {
            if(i-before-1 < 0)
            {
                break;
            }

            before = before +1;
            beforeSemantic = semantics.get(i-before-1);
        }

        while(afterSemantic == Semantics.maybeA || afterSemantic == Semantics.in)
        {
            after = after +1;
            if(i+before+1 >= size)
            {
                break;
            }
            afterSemantic = semantics.get(i+after);
        }

        return variables.subList(i-before, i+after);
    }
}

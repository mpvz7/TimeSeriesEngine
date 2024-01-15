package com.example.Decoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Aggregator;
import com.example.Feature;
import com.example.Constants.Semantics;
import com.example.Objects.ExtremesResult;

public class DecorationTableExtremes {
    
    // On utilise la table de décoration 3.35
    public ExtremesResult Decorate(
        String aggregator,
        String feature,
        List<Integer> variables,
        List<String> semantics)
    {
        Integer size = variables.size();

        List<Integer> found = new ArrayList<>(Collections.nCopies(size, 0));
        List<Integer> ct = new ArrayList<>(Collections.nCopies(size, 0));
        List<Integer> at = new ArrayList<>(Collections.nCopies(size, 0));

        Feature f = new Feature(feature);
        Aggregator agg = new Aggregator(aggregator);

        Integer defaultAgg = agg.getDefault(); // default(g, f)
        int C = defaultAgg;
        int D = Feature.getDefault();
        int R = defaultAgg;

        for (Integer i = 0; i < size - 1; i++) {

            String semantic = semantics.get(i);

            List<Integer> patternOccurence = getPatternOccurence(i, semantics, variables);
            Integer fValue = f.apply(patternOccurence); // Appliquer le feature

            switch (semantic) {
                case Semantics.out:
                    ct.set(i+1, ct.get(i));
                    at.set(i+1, at.get(i));
                    break;
                case Semantics.outR:
                    ct.set(i+1, ct.get(i));
                    at.set(i+1, at.get(i));
                    D = Feature.getDefault();
                    break;
                case Semantics.outA:
                    if(agg.compare(C, R)) {
                        at.set(i + 1, ct.get(i));
                    } else if (C == R) {
                        at.set(i + 1, ct.get(i));
                        at.set(i + 1, at.get(i)); //à verifier
                    } else {
                        at.set(i + 1, at.get(i));
                    }
                    C = defaultAgg;
                    D = Feature.getDefault();
                    R = agg.apply(R, C);
                    break;
                case Semantics.maybeB:
                    ct.set(i+1, ct.get(i));
                    at.set(i+1, at.get(i));
                    D = agg.apply(D, fValue); // Appliquer l'aggregateur
                    break;
                case Semantics.maybeA:
                    ct.set(i+1, ct.get(i));
                    at.set(i+1, at.get(i));
                    C = agg.apply(D, fValue);
                    break;
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

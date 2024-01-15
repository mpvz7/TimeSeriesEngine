package com.example.Computers.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.Constants.Patterns;
import com.example.Objects.PatternInterval;

public class PatternComputer {
    
    public List<PatternInterval> computePatterns(
        String pattern, 
        List<Integer> variables)
    {
        String signature = generateSignature(variables);

        return findPatterns(pattern, signature);
    }

    private String generateSignature(List<Integer> inputList) 
    {
        StringBuilder signature = new StringBuilder();

        for (int i = 0; i < inputList.size() - 1; i++) {
            int current = inputList.get(i);
            int next = inputList.get(i + 1);

            if (current < next) {
                signature.append('<');
            } else if (current == next) {
                signature.append('=');
            } else {
                signature.append('>');
            }
        }

        return signature.toString();
    }

     public List<PatternInterval> findPatterns(
        String pattern, 
        String signature)
    {
        String patternRegularExpression = Patterns.GetRegularExpression(pattern); // trouver l'expression régulière correspondante au patron
        Pattern regexPattern = Pattern.compile(patternRegularExpression);
        Matcher matcher = regexPattern.matcher(signature); // Trouver les résultats

        List<PatternInterval> results = new ArrayList<PatternInterval>();

        // Remplir les intervalles de l'occurence du patron
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            results.add(new PatternInterval(start, end));
        }

        return results;
    }
}

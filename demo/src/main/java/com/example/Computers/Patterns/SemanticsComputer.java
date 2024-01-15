package com.example.Computers.Patterns;

import java.util.List;

import com.example.Computers.Patterns.Increasing.IncreasingSemanticsComputer;
import com.example.Computers.Patterns.Peak.PeakSemanticsComputer;
import com.example.Computers.Patterns.Plateau.PlateauSemanticsComputer;
import com.example.Computers.Patterns.Steady.SteadySemanticsComputer;
import com.example.Constants.Patterns;

public class SemanticsComputer {
    
    private SignaturesComputer _signaturesComputer = new SignaturesComputer();

    private PeakSemanticsComputer _peakSemanticsComputer = new PeakSemanticsComputer();
    private IncreasingSemanticsComputer _increasingSemanticsComputer = new IncreasingSemanticsComputer();
    private SteadySemanticsComputer _steadySemanticsComputer = new SteadySemanticsComputer();
    private PlateauSemanticsComputer _plateauSemanticsComputer = new PlateauSemanticsComputer();


    public List<String> computeSemantics(
        List<Integer> variables,
        String pattern)
    {
        List<String> signature = _signaturesComputer.generateSignature(variables);

        if(pattern == Patterns.Peak)
        {
            return _peakSemanticsComputer.ComputeSemantics(signature);
        }
        if(pattern == Patterns.Increasing)
        {
            return _increasingSemanticsComputer.ComputeSemantics(signature);
        }
        if(pattern == Patterns.Steady)
        {
            return _steadySemanticsComputer.ComputeSemantics(signature);
        }
        if(pattern == Patterns.Plateau)
        {
            return _plateauSemanticsComputer.ComputeSemantics(signature);
        }

        return null;
    }
}

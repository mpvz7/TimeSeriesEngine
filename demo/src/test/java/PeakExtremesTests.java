import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.Feature;
import com.example.Computers.ExtremesComputer;
import com.example.Constants.Aggregators;
import com.example.Constants.Features;
import com.example.Constants.Patterns;
import com.example.Objects.ExtremesResult;

public class PeakExtremesTests
{
    @Test
    public void test1() 
    {
        ExtremesComputer extremesComputer = new ExtremesComputer();

        List<Integer> variables = List.of(3, 2, 2, 1, 2, 3, 1, 1, 2, 3, 4, 2, 3, 3, 3, 1);

        String aggregator = Aggregators.Min;
        String feature = Features.Max;
        String pattern = Patterns.Peak;

        ExtremesResult extremResults = extremesComputer.computeExtremes2(
            aggregator,
            feature, 
            pattern, 
            variables);

        if(extremResults == null){
            System.out.println("Il y'a eu un problème lors du calcul des extremes: ");
        }

        System.out.println(String.format("Pos_%s_%s_%s", aggregator, feature, pattern));
        System.out.print("Pour la série temporelle: ");
        ListPrinter.printList(extremResults.getVariables());
        Integer value = extremResults.getValue();
        System.out.println(String.format("La value est: %d", value));
        System.out.print("Le found est: ");
        ListPrinter.printList(extremResults.getFound());

        List<Integer> exprectedFound = List.of(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
        assertIterableEquals(exprectedFound, extremResults.getFound(), "Found lists should be the same!");
    }
}

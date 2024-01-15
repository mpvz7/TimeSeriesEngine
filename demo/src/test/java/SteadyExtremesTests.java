import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.Computers.ExtremesComputer;
import com.example.Constants.Aggregators;
import com.example.Constants.Features;
import com.example.Constants.Patterns;
import com.example.Objects.ExtremesResult;

public class SteadyExtremesTests
{
    @Test
    public void test1() 
    {
        ExtremesComputer extremesComputer = new ExtremesComputer();

        List<Integer> variables = List.of(1, 1, 4, 2, 2, 3, 3, 3, 4, 2, 2, 2, 4, 1, 3, 3);

        String aggregator = Aggregators.Min;
        String feature = Features.Max;
        String pattern = Patterns.Plateau;

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

        assertEquals(4, value);
        List<Integer> expectedFound = List.of(0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0);
        assertIterableEquals(expectedFound, extremResults.getFound());
    }
}

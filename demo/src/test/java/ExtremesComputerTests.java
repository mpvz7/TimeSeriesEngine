import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.Computers.ExtremesComputer;
import com.example.Objects.ExtremesResult;

public class ExtremesComputerTests
{
    @Test
    public void test1() 
    {
        ExtremesComputer extremesComputer = new ExtremesComputer();

        List<Integer> variables = List.of(5, 1, 4, 3, 2, 2, 2, 5, 4, 4, 1, 1, 4, 4, 3, 1);

        String aggregator = "min";
        String feature = "max";
        String pattern = "peak";

        ExtremesResult extremResults = extremesComputer.ComputeExtremes(
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
    }
}

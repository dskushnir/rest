package hillel.mySpringRest.repository;

import hillel.mySpringRest.model.Greeting;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class GreetingRepositoryTest {
    @Test
    public void shouldGetGreetingList() throws Exception {
        List<Greeting> testGreetingList = GreetingRepository.getGreetingList(100);
        double probabilityHello = 33.33;
        double probabilityBuongiorno = 33.33;
        double probabilityBonjour = 33.33;
        double chiSquareStandart1 = 5.991;
        double cchiSquareStandart2 = 9.210;
        System.out.println(testGreetingList);
        double numberGreetingType1 = GreetingRepository.getNumberGreetingType(testGreetingList, "Hello!");
        double numberGreetingType2 = GreetingRepository.getNumberGreetingType(testGreetingList, "Buongiorno!");
        double numberGreetingType3 = GreetingRepository.getNumberGreetingType(testGreetingList, "Bonjour!");
        System.out.println("Hello! -" + numberGreetingType1);
        System.out.println("Buongiorno !-" + numberGreetingType2);
        System.out.println("Bonjour!-" + numberGreetingType3);
        double addedChiSquareHello = (Math.pow(((numberGreetingType1) * 100.0 / testGreetingList.size() - probabilityHello), 2)) / probabilityHello;
        double addedChiSquareBuongiorno = (Math.pow(((numberGreetingType2) * 100.0 / testGreetingList.size() - probabilityBuongiorno), 2)) / probabilityBuongiorno;
        double addedChiSquareBonjour = (Math.pow(((numberGreetingType3) * 100.0 / testGreetingList.size() - probabilityBonjour), 2)) / probabilityBonjour;
        double chiSquare = addedChiSquareHello + addedChiSquareBuongiorno + addedChiSquareBonjour;
        boolean isEqualDistribution = chiSquare > chiSquareStandart1 && chiSquare < cchiSquareStandart2;
        if (isEqualDistribution) {
            System.out.println("It is equal distribution");
        } else {
            System.out.println("It is not equal distribution");
        }
    }
}







import task1.Pair;
import task2.Calculator;
import task3.Search;
import task4.Merge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {
    public static void main(String[] args) {

//      Task1_________________________________________________________________________
        Pair<String, String> pair1 = new Pair<>("First", "Second");
        System.out.println("Pair1 : " + pair1.getFirst() + " : " + pair1.getSecond());
        Pair<Double, Integer> pair2 = new Pair<>(12.4, 100);
        System.out.println("Pair2 : " + pair2.getFirst() + " : " + pair2.getSecond());
//      ______________________________________________________________________________

//      Task2_________________________________________________________________________
        Double[] array1 = {1.2, 1.3, 1.6, 2.5, 3.9};
        Integer[] array2 = {1, 13, 1, 5, 9};
        System.out.println("Average for array1: " + Calculator.calculateAverage(array1));
        System.out.println("Average for array2: " + Calculator.calculateAverage(array2));
//      ______________________________________________________________________________

//      Task3_________________________________________________________________________
        Collection<String> coll1 = List.of("Element1", "Element2", "string", "int", "value");
        System.out.println(Search.containsElement(coll1, "settings"));

        ArrayList<Integer> coll2 = new ArrayList<>(List.of(12, 29, 31, 56, 112));
        System.out.println(Search.containsElement(coll2, 29));
//      ______________________________________________________________________________

//      Task4_________________________________________________________________________
        List<String> list1 = List.of("Element1", "Element2", "string", "int", "value");
        List<String> list3 = List.of("(GG, WP)", "Audi_TT", "value");
        ArrayList<Integer> list2 = new ArrayList<>(List.of(12, 29, 31, 56, 112));
        ArrayList<Integer> list4 = new ArrayList<>(List.of(29, 31, 56, 112, 1228, 1337));
        
        System.out.println(Merge.mergeLists(list2, list4));
        System.out.println(Merge.mergeLists(list1, list3));
//      ______________________________________________________________________________

    }
}

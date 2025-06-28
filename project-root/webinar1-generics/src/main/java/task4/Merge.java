package task4;

import java.util.ArrayList;
import java.util.List;

public class Merge {
    public static <T> List<T> mergeLists(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }
}

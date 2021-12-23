package cs.vsu.sokolov.Logic;

import java.util.ArrayList;
import java.util.List;

public class ListHandler {

    public static <E> List<E> inList1NotInList2(List<E> list1, List<E> list2) {
        List<E> firstList = new ArrayList<>(list1);
        List<E> secondList = new ArrayList<>(list2);
        List<E> resultList = new ArrayList<>();

        for (E elem : firstList) {
            if (indexOf(secondList, elem) == -1) {
                resultList.add(elem);
            }
        }

        return resultList;
    }

    public static <T> int indexOf (List<T> list, T value) {
        int searchFailed = -1;
        int listLength = list.size();

        for (int i = 0; i < listLength; i++) {
            if (list.get(i).equals(value)) {
                return i;
            }
        }

        return searchFailed;
    }
}

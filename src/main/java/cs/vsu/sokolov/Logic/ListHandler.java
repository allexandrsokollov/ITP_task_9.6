package cs.vsu.sokolov.Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListHandler {

    public static <E> List<E> inList1NotInList2(List<E> list1, List<E> list2) {
        List<E> resultList = new ArrayList<>();

        for (E elem : list1) {
            if (indexOf(list2, elem) == -1) {
                resultList.add(elem);
            }
        }

        return resultList;
    }

    public static int[] IntListToArr (List<Integer> list) {
        if (list == null) {
            return null;
        }

        int[] result = new int[list.size()];

        int cnt = 0;
        for (Integer v : list) {
            result[cnt++] = v;
        }

        return result;
    }

    public static List<Integer> IntArrToList (int[] ints) {
        List<Integer> result = new ArrayList<>();

        if (ints == null) {
            return null;
        }

        for (int anInt : ints) {
            result.add(anInt);
        }
        return result;
    }

    public static <T> int indexOf (List<T> list, T value) {
        int searchFailed = -1;

        int i = 0;
        for (T v : list) {
            if (v.equals(value)) {
                return i;
            }
            i++;
        }

        return searchFailed;
    }
}

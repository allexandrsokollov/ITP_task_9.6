package cs.vsu.sokolov.Logic;

import java.util.List;
import java.util.TreeSet;

public class ListHandler<E> {
    private final List<E> list;

    public ListHandler (List<E> list) {
        this.list = list;
    }

    public static <T> List<T> inList1NotInList2(List<T> list1, List<T> list2) {
        TreeSet<T> firstTree = new TreeSet<>(list1);
        TreeSet<T> secondTree = new TreeSet<>(list2);

        for (T tree : firstTree) {
            if (secondTree.contains(tree))
        }
    }

    public int indexOf (List<E> list, E value) {
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

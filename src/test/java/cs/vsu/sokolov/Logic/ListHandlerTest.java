package cs.vsu.sokolov.Logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListHandlerTest {

    @Test
    public void inList1NotInList2Test() {

    List<Integer> list1 = new ArrayList<>();
    int[] l1 = new int[] {
            99, 55, 77, 33,
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 0, 12, 44};

    for (int i : l1) {
        list1.add(i);
    }

    List<ArrayList<Integer>> list2 = new ArrayList<>();
    int[][] testingArr = new int[][] {
            {99,1,5,9}, {55,2,6,0}, {77,3,7,12}, {33,4,8,44},
            {99, 55, 77, 33}, {1,2,3,4}, {5, 6,7,8,},
            {}, {44}, {125}
    };

    int counter = 0;

    for (int[] ints : testingArr) {
        list2.add(new ArrayList<>());

        for (int i : ints) {
            list2.get(counter++).add(i);
        }
    }

    List<ArrayList<Integer>> expected = new ArrayList<>();
    int[][] ex = new int[][] {
            {55,77,33,2,3,4,6,7,8,0,12,44},
            {99,77,33,1,3,4,5,7,8,9,12,44},
            {99, 55, 33, 1, 2,  4, 5, 6, 8, 9, 0, 44},
            {99, 55, 77, 1, 2, 3, 5, 6, 7, 9, 0, 12,},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 12, 44},
            {99, 55, 77, 33, 5, 6, 7, 8, 9, 0, 12, 44},
            {99, 55, 77, 33, 1, 2, 3, 4, 9, 0, 12, 44},
            {99, 55, 77, 33, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 12, 44},
            {99, 55, 77, 33, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 12},
            {99, 55, 77, 33, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 12, 44},
    };

    counter = 0;

    for (int[] ints : ex) {
        expected.add(new ArrayList<>());

        for (int i : ints) {
            expected.get(counter++).add(i);
        }
    }



    int j = 0;
    for (ArrayList<Integer> list : list2) {
        ArrayList<Integer> actual;
        ArrayList<Integer> exp;
        actual = new ArrayList<>(ListHandler.inList1NotInList2(list1, list));
        exp = expected.get(j++);

        int cnt = 0;
        for (Integer i : actual) {
            Assert.assertEquals(i, exp.get(cnt++));
        }
    }

    }
}
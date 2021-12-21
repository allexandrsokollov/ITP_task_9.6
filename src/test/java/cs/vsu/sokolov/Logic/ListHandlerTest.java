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
            99,      55,       77,       33,
            1,          2,          3,          4,
            5,         6,          7,       8,
            9,          0,         12,       44};

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
            list2.get(counter).add(i);
        }
        counter++;
    }

    for (ArrayList<Integer> list : list2) {
        ArrayList<Integer> actueal;
        actueal = new ArrayList<>(ListHandler.inList1NotInList2(list1, list));

        int cnt = 0;
        for (Integer i : actueal) {
            Assert.assertEquals(i, list.get(cnt));
            cnt++;
        }
    }





    }
}
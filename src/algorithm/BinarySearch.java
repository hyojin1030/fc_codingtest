package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public boolean search(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) return true;
        if (dataList.size() == 1 && searchItem != dataList.get(0)) return false;
        if (dataList.size() == 0) return false;

        int medium = dataList.size() / 2;

        if (searchItem == dataList.get(medium)) return true;
        else {
            if (searchItem < dataList.get(medium)) return search(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            else return search(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
        }


    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            dataList.add((int)(Math.random() * 100));
        }

        Collections.sort(dataList);
        System.out.println(dataList);

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(dataList, 4));


    }
}

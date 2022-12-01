package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public ArrayList<Integer> mergeSplit(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int medium = dataList.size() / 2;
        
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = mergeSplit(new ArrayList<Integer>(dataList.subList(0, medium)));
        rightArr = mergeSplit(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        return mergaFunc(leftArr, rightArr);

    }

    public ArrayList<Integer> mergaFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1: left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergeList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergeList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        // CASE2: right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergeList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        // CASE3: left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergeList.add(rightList.get(rightPoint));
            rightPoint++;
        }



        return mergeList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for(int index = 0 ; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        MergeSort mergeSort = new MergeSort();
        System.out.println(mergeSort.mergeSplit(testData));
    }
}

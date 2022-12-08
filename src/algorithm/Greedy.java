package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<>();

        for(int index = 0; index < coinList.size(); index++) {
            coinNum = price / coinList.get(index);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index) + "원 : " + coinNum + "개");
        }
        System.out.println("총 동전 갯수 : " + totalCoinCount);
    }

    public void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o2[1] / o2[0]) - (o1[1] / o2[0]);
            }
        });

        for (int index = 0; index < objectList.length; index++) {
            if (capacity - (double) objectList[index][0] > 0){
                capacity -= (double)objectList[index][0];
                totalValue += (double) objectList[index][1];
                System.out.println("무게 : " + objectList[index][0] + ", 가치 : " + objectList[index][1]);
            } else {
                fraction = capacity / (double) objectList[index][0];
                totalValue += (double)objectList[index][1] * fraction;
                System.out.println("무게 : " + objectList[index][0] + ", 가치 : " + objectList[index][1]);
            }
        }

        System.out.println("결과 : " + totalValue);

    }

    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};

        greedy.knapsackFunc(objectList, 30.0);

    }
}

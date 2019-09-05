package orderStatistic;

import problems.FloorCeilBinarySearch;

public class Main {
    public static void main(String args[]){
        OrderStatistics orderStatistics = new OrderStatisticsSelectionImpl();
        FloorCeilBinarySearch floo = new FloorCeilBinarySearch();
        Integer arr[] = {3, 4, 5, 5, 5, 5, 6, 7};
        System.out.println(floo.ceil(arr, 5));

    }
}

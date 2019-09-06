package orderStatistic;

import problems.FloorCeilBinarySearch;

public class Main {
    public static void main(String args[]){
        OrderStatistics orderStatistics = new OrderStatisticsSelectionImpl();
        FloorCeilBinarySearch floo = new FloorCeilBinarySearch();
        Integer arr[] = {2, 3, 5, 5, 5, 5, 6, 8};
        System.out.println(floo.ceil(arr, 5));
    }
}

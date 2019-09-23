package problems;

public class Teste {
    public static void main(String args[]){
        Integer[] arr1 = new Integer[5];
        arr1[0] = 4;
        arr1[1] = 5;
        arr1[2] = 7;
        arr1[3] = 11;
        arr1[4] = 12;
        Integer[] arr2 = new Integer[4];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        arr2[3] = 6;
        OrderStatisticsSortedUnion ot = new OrderStatisticsSortedUnion();
        System.out.println(ot.statisticsOrder(arr1, arr2, 4));
    }
}

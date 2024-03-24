package merge_overlapping_sub_interval;
import java.util.*;

public class Main {
//    BruteForce
    public static void main(String[] args) {
        int[][] arr = {{1, 2},
                {1, 3},
                {1, 6},
                {3, 4},
                {4, 4},
                {4, 5},
                {5, 5},
                {6, 6},
                {6, 6}};
        ArrayList<List<Integer>> arr1 = new ArrayList<>();
        arr1 = BruteForce.mergeOverlappingIntervals(arr);
        BruteForce.printList(arr1);
    }

}

class BruteForce {
    public static ArrayList<List<Integer>> mergeOverlappingIntervals(int [][]arr){
            ArrayList<List<Integer>> outerList = new ArrayList<>();

            for(int iterator = 0, looper = 0; iterator < arr.length; iterator++) {
                ArrayList<Integer> innerList = new ArrayList<>();
//                if(iterator > 0 && outerList.get(looper - 1).get(1) >= arr[iterator][0]) {
                if(iterator > 0 && arr[iterator][0] <= outerList.get(looper - 1).get(1) && arr[iterator][0] >= outerList.get(looper - 1).get(0)) {
                    if(arr[iterator][1] > outerList.get(looper -1).get(1)) {
                        innerList.add(outerList.get(looper - 1).get(0));
                        innerList.add(arr[iterator][1]);
                        outerList.set((looper - 1), innerList);
                    }
//                    innerList.add(outerList.get(looper - 1).get(0));
//                    innerList.add(arr[iterator][1]);

                } else {
                    innerList.add(arr[iterator][0]);
                    innerList.add(arr[iterator][1]);
                    outerList.add(innerList);
                    looper++;
                }

//                innerList.clear();
                System.out.print("When " + iterator + " = ");
                printList(outerList);
                System.out.println();
            }
            return outerList;
    }

    public static void printList(ArrayList<List<Integer>> outerList) {
        for (List<Integer> integers : outerList) {
            System.out.print(integers + " ");
        }
    }
}

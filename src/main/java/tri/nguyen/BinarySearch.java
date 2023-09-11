package tri.nguyen;

import java.util.Scanner;

public class BinarySearch {
    private static int binarySearch(int[] data, int value){
        int low = 0;
        int high = data.length -1;

        while (high >= low){
            int mid = (high + low)/2;

            System.out.println("mid: " + data[mid]);

            if (data[mid] == value){
                return mid;
            }
            else if (data[mid] > value){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -low -1;
    }

    private static int binarySearch(String[] data, String value){
        int low = 0;
        int high = data.length - 1;

        while (high >= low){
            int mid = (high + low)/2;

            System.out.println("mid: " + data[mid]);

            if (data[mid].equals(value)){
                return mid;
            }
            else if (value.compareTo(data[mid]) < 0){
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return -low -1;
    }

    public static void main(String[] args) {
        /*
            Binary Search:          Search algorithm that finds the position of a target value within a sorted array.
                                    Half of the array is eliminated during each "step"

            Runtime Complexity:     O(log n)

            Pros:
                                    1. Better than a linear search algorithm with the time complexity of O(n)
                                    2. At each iteration, the binary search algorithm eliminates half of the list
                                       and significantly reduces the search space
                                    3. Works even when the array is rotated by some position and finds the target element.
            Cons:
                                    1. The recursive method uses stack space.
                                    2. Caching is poor.
                                    3. Binary search is error-prone. Some common errors are:
                                        * Handling of duplicate items: While returning the first item,
                                          it might be possible we return a subsequence similar item.
                                        * Numerical underflows/overflows: In huge arrays when computing indices.
                                          There might be overflows
                                        * Recursive vs non-recursive implementation,
                                          which should be considered while designing as recursive takes stack space.
         */
        Scanner input = new Scanner(System.in);
        String[] countries = {"AT", "AU", "DE", "ES", "FR", "HU", "IS", "JP", "KR", "PT","TW", "US"};
        String value = "";

        // initiate an array of length 10000
        int[] array = new int[10000];

        // iterate to assign values from 0 to 9999 to the array
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int target;

        // prompt loop for string searching
        do {
            System.out.print("Enter a country code to search (not case sensitive) or Enter to exit: ");
            value = input.nextLine(); // input for string searching
            value = value.toUpperCase();

            // conditional statement for string searching
            if (!value.equals("")){
                int fountAtS = binarySearch(countries, value);
                System.out.printf("%s found at index %d\n", value, fountAtS);
            }
        } while (!value.equals(""));

        // prompt loop for number searching
        do {
            System.out.print("Enter a number to search or 0 to exit: ");
            target = input.nextInt(); // input for number searching

            // conditional statement for number searching
            if (target != 0) {
                int foundAtN = binarySearch(array, target);
                System.out.printf("%d found at index %d \n", target, foundAtN);
            }
        } while (target != 0);
    }
}



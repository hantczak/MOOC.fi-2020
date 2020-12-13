import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        MainProgram.sort(numbers);
    }

    public static int smallest(int[] array){
        int smallest = array[0];
        for (int number:array){
            if(smallest>number){
                smallest=number;
            }
        }
        return smallest;
    }

    public static int indexOfSmallest(int[] array){
        int indexOfSmallest = 0;
        int smallestValue = array[0];
        for (int i=0;i<array.length;i++){
            if (array[i]<smallestValue){
                smallestValue=array[i];
                indexOfSmallest=i;
            }
        }
        return indexOfSmallest;
    }

    public static int indexOfSmallestFrom(int[] array, int from){
        int indexOfSmallest = from;
        int smallestValue = array[from];
        for (int i=from;i<array.length;i++){
            if (array[i]<smallestValue){
                smallestValue=array[i];
                indexOfSmallest=i;
            }
        }
        return indexOfSmallest;
    }

    public static void swap(int[] array, int index1, int index2){
        int temp;
        temp = array[index1];
        array[index1]=array[index2];
        array[index2]=temp;

    }

    public static void sort(int[] array){
        for(int i=0;i<array.length;i++){
           swap(array,i,indexOfSmallestFrom(array,i));
            System.out.println(Arrays.toString(array));
        }

    }
}

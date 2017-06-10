import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by kuzuyayuudai on 2017/06/10.
 */
public class MySearch {
    private int elementCount;
    private int elementRange;
    private int[] myArray;

    public enum ArrayType {
        RANDOM,
        ASC,
        DESC
    }

    public MySearch(int elementCount, int elementRange) {
        this.myArray = randomArrayGenerator(elementCount, elementRange);
    }

    private int[] randomArrayGenerator(int elementCount, int elementRange) {
        int[] myArray = new int[elementCount];
        Random randomObj = new Random(elementRange);
        for (int indexMyArray = 0; indexMyArray < myArray.length; indexMyArray++) {
            myArray[indexMyArray] = randomObj.nextInt(myArray.length);
        }
        return myArray;
    }

    public int[] arraySortShuffle(int[] arrayToShuffle) {
        Random randomObj = new Random();
        for (int indexArrayToShuffle = 0; indexArrayToShuffle < arrayToShuffle.length; indexArrayToShuffle++) {
            int indexRandom = randomObj.nextInt(arrayToShuffle.length);
            swap(arrayToShuffle, indexArrayToShuffle, indexRandom);
        }
        return arrayToShuffle;
    }

    private static void swap(int[] array, int indexA, int indexB) {
        int indexTemp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = indexTemp;
    }

    public int[] arraySortAsc(int[] arrayToAsc) {
        MySort mySort = new MySort();
        arrayToAsc = mySort.quickSortMethod(arrayToAsc, 0, arrayToAsc.length - 1);
        return arrayToAsc;
    }

    public int[] getMyArray() {
        return myArray;
    }


    public SearchResult sequentialSearch(int targetNumber, int[] targetArray) {
        SearchResult mySearchResult = new SearchResult();
        for (int indexTargetArray = 0; indexTargetArray < targetArray.length; indexTargetArray++) {
            if (targetArray[indexTargetArray] == targetNumber) {
                mySearchResult.setFoundFlag(true);
                mySearchResult.setFoundElement(targetArray[indexTargetArray]);
                mySearchResult.setFoundIndex(indexTargetArray);
                break;
            }
        }
        return mySearchResult;
    }

    public SearchResult binarySearch(int targetNumber, int[] targetArray) {
        SearchResult mySearchResult = new SearchResult();
        int low = 0;
        int high = targetArray.length - 1;
        while (low <= high) {
            int centerPoint = (low + high) / 2;
            if(targetNumber < targetArray[centerPoint]){
                high = centerPoint - 1;
            }else if(targetArray[centerPoint] < targetNumber){
                low = centerPoint + 1;
            }else{
                mySearchResult.setFoundFlag(true);
                mySearchResult.setFoundIndex(centerPoint);
                mySearchResult.setFoundElement(targetArray[centerPoint]);
                break;
            }
        }
        return mySearchResult;
    }
}

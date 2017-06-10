import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by kuzuyayuudai on 2017/06/10.
 */
public class MainSearch {
    public static void mainSearch() {

        int elementCount = 20;
        int elementRange = 20;
        int targetNumber = 5;
        int[] randomArraySearchTarget = new int[elementCount];
        int[] ascArraySearchTarget = new int[elementCount];

        MySearch ms = new MySearch(elementCount, elementRange);

        //ランダム配列生成
        randomArraySearchTarget = ms.arraySortShuffle(ms.getMyArray());
        printArray(randomArraySearchTarget);

        //逐次探索
        printTime();
        SearchResult srRandomSequential = ms.sequentialSearch(targetNumber,randomArraySearchTarget);
        printTime();
        srRandomSequential.printSerchResult();
        if(srRandomSequential.isFoundFlag() == true) {
            System.out.println("srRandomSequential結果の配列番号からrandomArraySearchTargetを参照 --> "
                    + randomArraySearchTarget[srRandomSequential.getFoundIndex()]);
        }

        System.out.print("\n\n");

        //二分探索
        //ランダムの数列に対しては二分探索は使えない。
//        printTime();
//        SearchResult srRandomBinary = ms.binarySearch(targetNumber, randomArraySearchTarget);
//        printTime();
//        srRandomBinary.printSerchResult();
//        if(srRandomBinary.isFoundFlag() == true) {
//            System.out.println("srRandomBinary結果の配列番号からrandomArraySearchTargetを参照 --> "
//                    + randomArraySearchTarget[srRandomBinary.getFoundIndex()]);
//        }



        System.out.print("\n\n#######################################\n\n");


        //昇順配列生成
        ascArraySearchTarget = ms.arraySortAsc(ms.getMyArray());
        printArray(ascArraySearchTarget);

        //逐次探索
//        printTime();
//        SearchResult srAscSequential = ms.sequentialSearch(targetNumber,ascArraySearchTarget);
//        printTime();
//        srAscSequential.printSerchResult();
//        if(srAscSequential.isFoundFlag() == true) {
//            System.out.println("srAscSequential結果の配列番号からascArraySearchTargetを参照 --> "
//                    + ascArraySearchTarget[srAscSequential.getFoundIndex()]);
//        }

        System.out.print("\n\n");

        //二分探索
        printTime();
        SearchResult srAscBinary = ms.binarySearch(targetNumber, randomArraySearchTarget);
        printTime();
        srAscBinary.printSerchResult();
        if(srAscBinary.isFoundFlag() == true) {
            System.out.println("srAscBinary結果の配列番号からrandomArraySearchTargetを参照 --> "
                    + randomArraySearchTarget[srAscBinary.getFoundIndex()]);
        }

    }

    public static void printTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("This time is ... " + sdf.format(c.getTime()));
    }
    public static void printArray(int[] myArray) {
        String separator = System.getProperty("line.separator");
        System.out.print("[");
        for (int n = 0; n < myArray.length - 1; n++) {
            System.out.print(myArray[n] + ",");
        }
        System.out.print(myArray[myArray.length - 1] + "]" +
                separator + "and myArray.length is " + myArray.length);
        System.out.println("");

    }
}

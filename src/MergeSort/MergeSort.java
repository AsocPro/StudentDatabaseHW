package MergeSort;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author zachary
 */
public class MergeSort 
{
    private static final int THRESHHOLD = 4;
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        for(int index = 0; index < 100; index++)
        {
            list.add((int)(Math.random()*1000));
        }
        printList(list);
    }
    private static void printList(LinkedList list)
    {
        ListIterator itr = list.listIterator(0);
        for(int index = 0; index<10;index++)
        {
            for(int index1 = 0; index1< 10; index1++)
            {
                System.out.print(itr.next()+ "\t");
            }
            System.out.println("");
        }
    }
    public static LinkedList mergeSort(LinkedList<Integer> list)
    {
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        if(array.length < THRESHHOLD)
        {
            //selectionsort
        }
        int start = 0;
        int end = array.length-1;
        mergeSortInternal(array, start, end/2);
        mergeSortInternal(array, end/2+1, end);
        merge(array, start, end/2,end/2+1, end);
    }
    private static void mergeSortInternal(Integer[] array, int start, int end)
    {
        if((end-start) <= THRESHHOLD)
        {
            //insertion sort
        }
        mergeSortInternal(array, start, end/2);
        mergeSortInternal(array, end/2+1, end);
        merge(array, start, end/2,end/2+1, end);
    }
    private static void merge(Integer[] array, int start1, int end1, int start2, int end2)
    {
        //merge
    }
}
package MergeSort;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author zachary
 */
public class MergeSort 
{
    private static final int THRESHHOLD = 2;
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        for(int index = 0; index < 100; index++)
        {
            list.add((int)(Math.random()*1000));
        }
        printList(list);
        mergeSort(list);
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
        if(array.length <= THRESHHOLD)
        {
            if(array[end] > array[start])
            {
                Integer temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            }
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
            if(array[end] > array[start])
            {
                Integer temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            }
        }
        mergeSortInternal(array, start, end/2);
        mergeSortInternal(array, end/2+1, end);
        merge(array, start, end/2,end/2+1, end);
    }
    private static void merge(Integer[] array, int start1, int end1, int start2, int end2)
    {
        Integer[] tempArray = new Integer[end1-start1];
        for(int index = start1; index <= end1; index++)
        {
            tempArray[start1-index] = array[index];
        }
        for(int index=0; index <= (end1-start1); index++)
        {
            
        }
    }
}

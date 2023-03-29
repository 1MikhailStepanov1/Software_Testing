package secondTask;

import lab1.secondTask.FibonacciHeap;
import lab1.secondTask.FibonacciHeapNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Fibonacci Heap Test")
public class FibonacciHeapTest {

    private FibonacciHeap heap;

    private final int[] arr1 = {10, 7, 15, 2, 3};
    private final int[] arr2 = {25, 634, 44, 70, 5, 8, 17, 21, 24};
    private final int[] arr3 = {646, 543, 982, 33, 10, 28, 29, 46, 73, 7};
    private final int[] arr4 = {235, 256, 666, 885, 123, 44, 51, 55, 987, 8, 5, 7, 29};
    private final int[] arr5 = {523, 216, 778, 96, 50, 41, 66, 90, 234, 666, 68, 854};
    private final int[] arr6 = {471, 842, 940, 477, 88, 90, 312, 44, 16, 7};

    private void insert(int[] arr){
        for (int i : arr){
            heap.insert(i);
        }
    }

    @BeforeEach
    public void setUp() {
        heap = FibonacciHeap.create_heap();
    }

    @Test
    public void insertAndExtractMinTest() {
        heap.extract_min();
        heap.insert(25);
        heap.extract_min();
        insert(arr1);
        heap.extract_min();
        StringBuilder result = new StringBuilder();
        result = heap.display(result);
        assertEquals("(3(7(10()->)->15()->)->)", result.toString());
        heap.extract_min();
    }

    @Test
    public void insertAndSearchTest(){
        insert(arr2);
        heap.extract_min();
        FibonacciHeapNode node = heap.find(44);
        assertEquals(44, node.key);
    }

    @Test
    public void insertAndMergeHeaps(){
        FibonacciHeap newHeap = FibonacciHeap.create_heap();
        for (int i : arr5){
            newHeap.insert(i);
        }
        newHeap.extract_min();

        FibonacciHeap newHeap2 = FibonacciHeap.create_heap();
        for (int i : arr6){
            newHeap2.insert(i);
        }
        newHeap2.extract_min();

        FibonacciHeap.merge_heap(heap, newHeap, newHeap2);
        insert(arr4);
        heap.extract_min();

        FibonacciHeap.merge_heap(heap, newHeap, newHeap2);
        assertEquals(7, newHeap2.min.key);
    }
}

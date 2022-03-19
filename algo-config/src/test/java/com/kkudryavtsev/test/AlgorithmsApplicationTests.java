package com.kkudryavtsev.test;

import com.kkudryavtsev.sort.component.Sorter;
import com.kkudryavtsev.util.annotations.ArraySource;
import com.kkudryavtsev.util.annotations.ArraySources;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = Sorter.class)
class AlgorithmsApplicationTests {

    @Test
    void contextLoads() {
    }

    @ParameterizedTest
    @ArraySources(
            arrays = {
                    @ArraySource(array = {1, 2, 3}),
                    @ArraySource(array = {4, 5, 6}),
                    @ArraySource(array = {7, 8, 9})
            }
    )
    public void testBubbleSort(int[] arr) {

        assertTrue(isSortedInAsc(Sorter.sort(arr, "bubble")));
    }

    private boolean isSortedInAsc(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}

package lesson6.homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {
    private Shift shift;

    @BeforeEach
    void startUp() {
        System.out.println("начинается тест");
        shift = new Shift();
    }

    @AfterEach
    void shutdown() {
        System.out.println("тест завершается\n");
    }

    @DisplayName("Параметризированный тест проверки смещения")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(String expected, int[] array, int n) {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Assertions.assertEquals(expected, shift.shiftArray(array, n));
        });
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(Arrays.toString(new int[]{1, 2, 3, 4, 5}), new int[]{1, 2, 3, 4, 5}, 0),
                Arguments.arguments(Arrays.toString(new int[]{5, 1, 2, 3, 4}), new int[]{1, 2, 3, 4, 5}, 1),
                Arguments.arguments(Arrays.toString(new int[]{4, 5, 1, 2, 3}), new int[]{1, 2, 3, 4, 5}, 2),
                Arguments.arguments(Arrays.toString(new int[]{1, 2, 3, 4, 5}), new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.arguments(Arrays.toString(new int[]{5, 1, 2, 3, 4}), new int[]{1, 2, 3, 4, 5}, 6),
                Arguments.arguments(Arrays.toString(new int[]{2, 3, 4, 5, 1}), new int[]{1, 2, 3, 4, 5}, -1),
                Arguments.arguments(Arrays.toString(new int[]{3, 4, 5, 1, 2}), new int[]{1, 2, 3, 4, 5}, -2),
                Arguments.arguments(Arrays.toString(new int[]{1, 2, 3, 4, 5}), new int[]{1, 2, 3, 4, 5}, -5),
                Arguments.arguments(Arrays.toString(new int[]{2, 3, 4, 5, 1}), new int[]{1, 2, 3, 4, 5}, -6)
        );
    }
}
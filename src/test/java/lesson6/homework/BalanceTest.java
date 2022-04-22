package lesson6.homework;

import lesson6.test.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {
    private Balance balance;

    @BeforeEach
    void startUp() {
        System.out.println("начинается тест");
        balance = new Balance();
    }

    @AfterEach
    void shutdown() {
        System.out.println("тест завершается\n");
    }

    @DisplayName("Проверка баланса №1")
    @Test
    void testAdd1() {
        Assertions.assertEquals(true, balance.checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
    }

    @DisplayName("Проверка баланса №2")
    @Test
    void testAdd2() {
        Assertions.assertEquals(true, balance.checkBalance(new int[] {1, 1, 1, 2, 1}));
    }

    @DisplayName("Проверка баланса №3")
    @Test
    void testAdd3() {
        assertTrue(balance.checkBalance(new int[]{3, 5}));
    }

    @DisplayName("Проверка баланса №4")
    @Test
    void testAdd4() {
        assertTrue(balance.checkBalance(new int[]{1, 2, 0, 0, 3}));
    }

    @DisplayName("Параметризированный тест проверки баланса")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(boolean expected, int[] a) {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Assertions.assertEquals(expected, balance.checkBalance(a));
        });
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(true, new int[]{2, 2, 2, 1, 2, 2, 10, 1}),
                Arguments.arguments(true, new int[] {1, 1, 1, 2, 1}),
                Arguments.arguments(false, new int[] {3, 5}),
                Arguments.arguments(true, new int[] {1, 2, 0, 0, 3})
        );
    }
}
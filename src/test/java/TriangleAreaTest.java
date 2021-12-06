
import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// Для тест дизайна данного набора следует рассмотреть передаваемые числа как классы эквивалентности с граничными значениями
// В требованиях у функции сказано, что на вход она получает тип int, а значит выделить 3 класса эквивалентности с граничнными значениями:
// [-2_147_483_648 ; -1] [0] [1 ; 2_147_483_647]
// Теперь конкретизируем внимание на треугольнике и его поведении
// Все стороны треугольника должны иметь длину то есть описываться положительным числом
// Одна сторона треугольника должна быть меньше или равна суммы двух других, при равенстве тругольник будет вырожденным
// Для увеличения тестового покрытия первые необходимо протестировать различные комбинации
// Разделим наборы тестов на позитивые, которые возвращают число и негативные, которые выкидывают ошибку

public class TriangleAreaTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleAreaTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Начинаем тест функции для расчёта площади треугольника по трём сторонам");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(){
        logger.info("Новый тест-кейс");
    }


    @Test
    @DisplayName("Передадим в метод отрицательную сторону А по минимальной границе")
    void givenNegativeSideAMinWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{-1,1,1}));
    }


    @Test
    @DisplayName("Передадим в метод отрицательную сторону В по минимальной границе")
    void givenNegativeSideBMinWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,-1,1}));
    }


    @Test
    @DisplayName("Передадим в метод отрицательную сторону С по минимальной границе")
    void givenNegativeSideCMinWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,1,-1}));
    }


    @Test
    @DisplayName("Передадим в метод отрицательную сторону А по максимальной границе")
    void givenNegativeSideAMaxWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{-2_147_483_648,2_147_483_647,2_147_483_647}));
    }


    @Test
    @DisplayName("Передадим в метод отрицательную сторону В по максимальной границе")
    void givenNegativeSideBMaxWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{2_147_483_647,-2_147_483_648,2_147_483_647}));
    }


    @Test
    @DisplayName("Передадим в метод отрицательную сторону С по максимальной границе")
    void givenNegativeSideCMaxWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.NegativeSide.class, ()-> TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_647,-2_147_483_648}));
    }


    @Test
    @DisplayName("Передадим в метод нулевую сторону А")
    void givenZeroSideAWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.ZeroSide.class, ()-> TriangleArea.TriangleArea(new int[]{0,1,1}));
    }


    @Test
    @DisplayName("Передадим в метод нулевую сторону В")
    void givenZeroSideBWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.ZeroSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,0,1}));
    }


    @Test
    @DisplayName("Передадим в метод нулевую сторону С")
    void givenZeroSideCWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.ZeroSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,1,0}));
    }


    @Test
    @DisplayName("Передадим в метод сторону A длина которой больше суммы двух других сторон по минимальной границе")
    void givenLongSideAMinWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{3,1,1}));
    }


    @Test
    @DisplayName("Передадим в метод сторону B длина которой больше суммы двух других сторон по минимальной границе")
    void givenLongSideBMinWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,3,1}));
    }


    @Test
    @DisplayName("Передадим в метод сторону C длина которой больше суммы двух других сторон по минимальной границе")
    void givenLongSideCMinWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1,1,3}));
    }


    @Test
    @DisplayName("Передадим в метод сторону A длина которой больше суммы двух других сторон по максимальной границе")
    void givenLongSideAMaxWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{2_147_483_647,1_073_741_823,1_073_741_823}));
    }


    @Test
    @DisplayName("Передадим в метод сторону B длина которой больше суммы двух других сторон по максимальной границе")
    void givenLongSideBMaxWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1_073_741_823,2_147_483_647,1_073_741_823}));
    }


    @Test
    @DisplayName("Передадим в метод сторону C длина которой больше суммы двух других сторон по максимальной границе")
    void givenLongSideCMaxWhenTriangleAreaThenNull() {
        Assertions.assertThrows(TriangleArea.TooLongSide.class, ()-> TriangleArea.TriangleArea(new int[]{1_073_741_823,1_073_741_823,2_147_483_647}));
    }

    @Test
    @DisplayName("Передадим в метод сторону A длина которой равна суммы двух других сторону по минимальной границе")
    void givenEqualSideAMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2,1,1});
        Assertions.assertEquals(0.0, result);
    }


    @Test
    @DisplayName("Передадим в метод сторону B длина которой равна суммы двух других сторону по минимальной границе")
    void givenEqualSideBMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{1,2,1});
        Assertions.assertEquals(0.0, result);
    }


    @Test
    @DisplayName("Передадим в метод сторону C длина которой равна суммы двух других сторону по минимальной границе")
    void givenEqualSideCMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{1,1,2});
        Assertions.assertEquals(0.0, result);
    }


    @Test
    @DisplayName("Передадим в метод сторону A длина которой равна суммы двух других сторону по максимальной границе")
    void givenEqualSideAMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_647,1_073_741_824,1_073_741_823});
        Assertions.assertEquals(0.0, result);
    }


    @Test
    @DisplayName("Передадим в метод сторону B длина которой равна суммы двух других сторону по максимальной границе")
    void givenEqualSideBMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{1_073_741_824,2_147_483_647,1_073_741_823});
        Assertions.assertEquals(0.0, result);
    }


    @Test
    @DisplayName("Передадим в метод сторону C длина которой равна суммы двух других сторону по максимальной границе")
    void givenEqualSideCMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_647,1_073_741_824,1_073_741_823});
        Assertions.assertEquals(0.0, result);
    }


    @Test
    @DisplayName("Передадим в метод равносторонний треугольник по минимальной границе")
    void givenNormalSideMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{1,1,1});
        Assertions.assertEquals(0.4330127018922193, result);
    }


    @Test
    @DisplayName("Передадим в метод равносторонний треугольник по максимальной границе")
    void givenNormalSideMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_647,2_147_483_647});
        Assertions.assertEquals(1.99691862125803904E18, result);
    }


    @Test
    @DisplayName("Передадим в метод равнобедренный треугольник с основанием А по минимальной границе")
    void givenBaseSideAMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{1,2,2});
        Assertions.assertEquals(0.9682458365518543, result);
    }


    @Test
    @DisplayName("Передадим в метод равнобедренный треугольник с основанием В по минимальной границе")
    void givenBaseSideBMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2,1,2});
        Assertions.assertEquals(0.9682458365518543, result);
    }


    @Test
    @DisplayName("Передадим в метод равнобедренный треугольник с основанием С по минимальной границе")
    void givenBaseSidCeMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2,2,1});
        Assertions.assertEquals(0.9682458365518543, result);
    }


    @Test
    @DisplayName("Передадим в метод равнобедренный треугольник с основанием А по максимальной границе")
    void givenBaseSideAMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_646,2_147_483_647,2_147_483_647});
        Assertions.assertEquals(1.99691862063811379E18, result);
    }


    @Test
    @DisplayName("Передадим в метод равнобедренный треугольник с основанием В по максимальной границе")
    void givenBaseSideBMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_646,2_147_483_647});
        Assertions.assertEquals(1.99691862063811379E18, result);
    }


    @Test
    @DisplayName("Передадим в метод равнобедренный треугольник с основанием С по максимальной границе")
    void givenBaseSidCeMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_647,2_147_483_646});
        Assertions.assertEquals(1.99691862063811379E18, result);
    }


    @Test
    @DisplayName("Передадим в метод треугольник с разными сторонами по минимальной границе")
    void givenDiffSideAMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2,3,4});
        Assertions.assertEquals(2.9047375096555625, result);
    }


    @Test
    @DisplayName("Передадим в метод треугольник с разными сторонами по минимальной границе")
    void givenDiffSideBMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{4,2,3});
        Assertions.assertEquals(2.9047375096555625, result);
    }


    @Test
    @DisplayName("Передадим в метод треугольник с разными сторонами по минимальной границе")
    void givenDiffSideCMaxWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{3,4,2});
        Assertions.assertEquals(2.9047375096555625, result);
    }


    @Test
    @DisplayName("Передадим в метод треугольник с разными сторонами по максимальной границе")
    void givenDiffSideAMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_645,2_147_483_646,2_147_483_647});
        Assertions.assertEquals(1.99691861939826355E18, result);
    }


    @Test
    @DisplayName("Передадим в метод треугольник с разными сторонами по максимальной границе")
    void givenDiffSideBMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_647,2_147_483_645,2_147_483_646});
        Assertions.assertEquals(1.99691861939826355E18, result);
    }


    @Test
    @DisplayName("Передадим в метод треугольник с разными сторонами по максимальной границе")
    void givenDiffSideCMinWhenTriangleAreaThenNull() throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Double result = TriangleArea.TriangleArea(new int[]{2_147_483_646,2_147_483_647,2_147_483_645});
        Assertions.assertEquals(1.99691861939826355E18, result);
    }

    @AfterAll
    static void afterAll(){
        System.out.println();
        System.out.println("Завершился тест функции для расчёта площади треугольника по трём сторонам");
    }
}
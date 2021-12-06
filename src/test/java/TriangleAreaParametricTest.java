
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


// Для тест дизайна данного набора следует рассмотреть передаваемые числа как классы эквивалентности с граничными значениями
// В требованиях у функции сказано, что на вход она получает тип int, а значит выделить 3 класса эквивалентности с граничнными значениями:
// [-2_147_483_648 ; -1] [0] [1 ; 2_147_483_647]
// Теперь конкретизируем внимание на треугольнике и его поведении
// Все стороны треугольника должны иметь длину то есть описываться положительным числом
// Одна сторона треугольника должна быть меньше или равна суммы двух других, при равенстве тругольник будет вырожденным
// Для увеличения тестового покрытия первые необходимо протестировать различные комбинации
// Разделим наборы тестов на позитивые, которые возвращают число и негативные, которые выкидывают ошибку

public class TriangleAreaParametricTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleAreaTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Начинаем тест функции для расчёта площади треугольника по трём сторонам");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(){
        logger.info("Новый тест-кейс");
        System.out.println();
    }

    @ParameterizedTest
    @MethodSource ("numbersAndResultDataProvider")
    @DisplayName("Передаём в функцию различные входные данные и оцениваем результат")
    void givenNumbersWhenTriangleAreaThenNumber(int[] ints, Object result) throws TriangleArea.NegativeSide, TriangleArea.ZeroSide, TriangleArea.TooLongSide {
        Assertions.assertEquals(result, TriangleArea.TriangleArea(ints));
    }

    private static List<Arguments> numbersAndResultDataProvider (){
        return Arrays.asList(
                Arguments.of(new int[]{2,1,1}, 0.0),
                Arguments.of(new int[]{1,2,1}, 0.0),
                Arguments.of(new int[]{1,1,2}, 0.0),
                Arguments.of(new int[]{2_147_483_647,1_073_741_824,1_073_741_823}, 0.0),
                Arguments.of(new int[]{1_073_741_824,2_147_483_647,1_073_741_823}, 0.0),
                Arguments.of(new int[]{2_147_483_647,1_073_741_824,1_073_741_823}, 0.0),
                Arguments.of(new int[]{1,1,1}, 0.4330127018922193),
                Arguments.of(new int[]{2_147_483_647,2_147_483_647,2_147_483_647}, 1.99691862125803904E18),
                Arguments.of(new int[]{1,2,2}, 0.9682458365518543),
                Arguments.of(new int[]{2,1,2}, 0.9682458365518543),
                Arguments.of(new int[]{2,2,1}, 0.9682458365518543),
                Arguments.of(new int[]{2_147_483_646,2_147_483_647,2_147_483_647}, 1.99691862063811379E18),
                Arguments.of(new int[]{2_147_483_647,2_147_483_646,2_147_483_647}, 1.99691862063811379E18),
                Arguments.of(new int[]{2_147_483_647,2_147_483_647,2_147_483_646}, 1.99691862063811379E18),
                Arguments.of(new int[]{2,3,4}, 2.9047375096555625),
                Arguments.of(new int[]{4,2,3}, 2.9047375096555625),
                Arguments.of(new int[]{3,4,2}, 2.9047375096555625),
                Arguments.of(new int[]{2_147_483_645,2_147_483_646,2_147_483_647}, 1.99691861939826355E18),
                Arguments.of(new int[]{2_147_483_647,2_147_483_645,2_147_483_646}, 1.99691861939826355E18),
                Arguments.of(new int[]{2_147_483_646,2_147_483_647,2_147_483_645}, 1.99691861939826355E18)
        );
    }

    @ParameterizedTest
    @MethodSource ("numbersAndExceptionDataProvider")
    @DisplayName("Передаём в функцию различные входные данные и оцениваем вывод ошибки")
    void givenNumberWhenTriangleAreaThenException(int[] ints, Throwable e  ) {
        Assertions.assertThrows(e.getClass(), () -> TriangleArea.TriangleArea(ints));
    }

    private static List<Arguments> numbersAndExceptionDataProvider (){
        return Arrays.asList(
                Arguments.of(new int[]{-1,1,1}, new TriangleArea.NegativeSide()),
                Arguments.of(new int[]{1,-1,1}, new TriangleArea.NegativeSide()),
                Arguments.of(new int[]{1,1,-1}, new TriangleArea.NegativeSide()),
                Arguments.of(new int[]{-2_147_483_648,2_147_483_647,2_147_483_647}, new TriangleArea.NegativeSide()),
                Arguments.of(new int[]{2_147_483_647,-2_147_483_648,2_147_483_647}, new TriangleArea.NegativeSide()),
                Arguments.of(new int[]{2_147_483_647,2_147_483_647,-2_147_483_648}, new TriangleArea.NegativeSide()),
                Arguments.of(new int[]{0,1,1}, new TriangleArea.ZeroSide()),
                Arguments.of(new int[]{1,0,1}, new TriangleArea.ZeroSide()),
                Arguments.of(new int[]{1,1,0}, new TriangleArea.ZeroSide()),
                Arguments.of(new int[]{3,1,1}, new TriangleArea.TooLongSide()),
                Arguments.of(new int[]{1,3,1}, new TriangleArea.TooLongSide()),
                Arguments.of(new int[]{1,1,3}, new TriangleArea.TooLongSide()),
                Arguments.of(new int[]{2_147_483_647,1_073_741_823,1_073_741_823}, new TriangleArea.TooLongSide()),
                Arguments.of(new int[]{1_073_741_823,2_147_483_647,1_073_741_823}, new TriangleArea.TooLongSide()),
                Arguments.of(new int[]{1_073_741_823,1_073_741_823,2_147_483_647}, new TriangleArea.TooLongSide())
        );
    }

    @AfterEach
    void afterEach(){
        logger.info("Тест-кейс завершился");
        System.out.println();
    }


    @AfterAll
    static void afterAll(){
        System.out.println();
        System.out.println("Завершился тест функции для расчёта площади треугольника по трём сторонам");
    }

}

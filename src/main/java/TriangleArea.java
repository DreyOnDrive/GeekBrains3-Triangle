public class TriangleArea {

    public static Double TriangleArea( int[] ints) throws NegativeSide, ZeroSide, TooLongSide {
        double a = ints[0];
        double b = ints[1];
        double c = ints[2];
        Double s = -1.0;

        if (a < 0.0 | b < 0.0 | c < 0.0) {
            if(a < 0.0) {
                System.out.println("Сторона A треугольника не может быть отрицательна");
                System.out.println();
                throw new NegativeSide ();
            }

            if(b < 0.0) {
                System.out.println("Сторона B треугольника не может быть отрицательна");
                System.out.println();
                throw new NegativeSide ();
            }

            if(c < 0.0) {
                System.out.println("Сторона C треугольника не может быть отрицательна");
                System.out.println();
                throw new NegativeSide ();
            }
        }

        if (a == 0.0 | b == 0.0 | c == 0.0) {
            if(a == 0.0) {
                System.out.println("Сторона A треугольника не может быть равна 0");
                System.out.println();
                throw new ZeroSide ();
            }

            if(b == 0.0){
                System.out.println("Сторона B треугольника не может быть равна 0");
                System.out.println();
                throw new ZeroSide ();
            }

            if(c == 0.0) {
                System.out.println("Сторона C треугольника не может быть равна 0");
                System.out.println();
                throw new ZeroSide ();
            }
        }

        if (a + b < c | a + c < b | b + c < a) {
            if(a + b < c) {
                System.out.println("Сторона С треугольника не может быть больше суммы А и В");
                System.out.println();
                throw new TooLongSide ();
            }
            if(a + c < b){
                System.out.println("Сторона В треугольника не может быть больше суммы А и С");
                System.out.println();
                throw new TooLongSide ();
            }
            if(b + c < a) {
                System.out.println("Сторона А треугольника не может быть больше суммы В и С");
                System.out.println();
                throw new TooLongSide ();
            }
        }

        if (a + b == c | a + c == b | b + c == a) {
            if(a + b == c) System.out.println("Сторона С треугольника равна сумме сторон А и В");
            if(a + c == b) System.out.println("Сторона В треугольника равна сумме сторон А и С");
            if(b + c == a) System.out.println("Сторона А треугольника равна сумме сторон В и С");
            System.out.println("Это вырожденный треугольник");
            System.out.println();
            return 0.0;
        }

        if (a + b >= c & a + c >= b & b + c >= a) {
            double pD = (a + b + c) / 2.0;
            s = Math.sqrt(pD * (pD - a) * (pD - b) * (pD - c));
            System.out.println("Площадь треугольника равна: " + s);
            System.out.println();
            return s;
        }
        return s;
    }

    public static class NegativeSide extends Throwable {
    }

    public static class ZeroSide extends Throwable {
    }

    public static class TooLongSide extends Throwable {
    }
}
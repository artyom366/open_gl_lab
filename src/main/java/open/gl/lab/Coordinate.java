package open.gl.lab;

public class Coordinate {

    private float x;
    private float y;

    public Coordinate() {
    }

    public Coordinate(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public static Coordinate[] getLetterAOuterCoordinates() {
        final Coordinate[] coordinates = new Coordinate[8];

        coordinates[0] = new Coordinate(30, 30);
        coordinates[1] = new Coordinate(35, 50);
        coordinates[2] = new Coordinate(40, 50);
        coordinates[3] = new Coordinate(45, 30);
        coordinates[4] = new Coordinate(43, 30);
        coordinates[5] = new Coordinate(40, 40);
        coordinates[6] = new Coordinate(35, 40);
        coordinates[7] = new Coordinate(32, 30);

        return coordinates;
    }

    public static Coordinate[] getLetterAInnerCoordinates() {
        final Coordinate[] coordinates = new Coordinate[4];

        coordinates[0] = new Coordinate(36, 42);
        coordinates[1] = new Coordinate(37, 48);
        coordinates[2] = new Coordinate(38, 48);
        coordinates[3] = new Coordinate(39, 42);

        return coordinates;
    }

    public static int[] getLetterAOuterCodes() {
        final int[] codes = new int[9];

        codes[0] = 0;
        codes[1] = 1;
        codes[2] = 2;
        codes[3] = 3;
        codes[4] = 4;
        codes[5] = 5;
        codes[6] = 6;
        codes[7] = 7;
        codes[8] = 0;

        return codes;
    }

    public static int[] getLetterAInnerCodes() {
        final int[] codes = new int[5];

        codes[0] = 0;
        codes[1] = 1;
        codes[2] = 2;
        codes[3] = 3;
        codes[4] = 0;

        return codes;
    }

    public static Coordinate[] getLetterROuterCoordinates() {
        final Coordinate[] coordinates = new Coordinate[6];

        coordinates[0] = new Coordinate(50, 30);
        coordinates[1] = new Coordinate(50, 50);
        coordinates[2] = new Coordinate(62, 50);
        coordinates[3] = new Coordinate(62, 41);
        coordinates[4] = new Coordinate(53, 41);
        coordinates[5] = new Coordinate(53, 30);

        return coordinates;
    }

    public static int[] getterROuterCodes() {
        final int[] codes = new int[7];

        codes[0] = 0;
        codes[1] = 1;
        codes[2] = 2;
        codes[3] = 3;
        codes[4] = 4;
        codes[5] = 5;
        codes[6] = 0;


        return codes;
    }

    public static Coordinate[] getLetterRInnerCoordinates() {
        final Coordinate[] coordinates = new Coordinate[4];

        coordinates[0] = new Coordinate(52, 48);
        coordinates[1] = new Coordinate(60, 48);
        coordinates[2] = new Coordinate(60, 43);
        coordinates[3] = new Coordinate(52, 43);

        return coordinates;
    }

    public static int[] getterRInnerCodes() {
        final int[] codes = new int[7];

        codes[0] = 0;
        codes[1] = 1;
        codes[2] = 2;
        codes[3] = 3;
        codes[4] = 0;

        return codes;
    }


}

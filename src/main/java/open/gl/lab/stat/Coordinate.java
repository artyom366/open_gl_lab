package open.gl.lab.stat;

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

    public static Coordinate[] getLetterACoordinates() {
        final Coordinate[] coordinates = new Coordinate[12];

        coordinates[0] = new Coordinate(30, 30);
        coordinates[1] = new Coordinate(35, 50);
        coordinates[2] = new Coordinate(40, 50);
        coordinates[3] = new Coordinate(45, 30);
        coordinates[4] = new Coordinate(43, 30);
        coordinates[5] = new Coordinate(40, 40);
        coordinates[6] = new Coordinate(35, 40);
        coordinates[7] = new Coordinate(32, 30);
        coordinates[8] = new Coordinate(36, 42);
        coordinates[9] = new Coordinate(37, 48);
        coordinates[10] = new Coordinate(38, 48);
        coordinates[11] = new Coordinate(39, 42);

        return coordinates;
    }

    public static int[] getLetterACodes() {
        final int[] codes = new int[14];

        codes[0] = 0;
        codes[1] = 1;
        codes[2] = 2;
        codes[3] = 3;
        codes[4] = 4;
        codes[5] = 5;
        codes[6] = 6;
        codes[7] = 7;
        codes[8] = 0;
        codes[9] = -8;
        codes[10] = 9;
        codes[11] = 10;
        codes[12] = 11;
        codes[13] = 8;

        return codes;
    }

    public static Coordinate[] getLetterRCoordinates() {
        final Coordinate[] coordinates = new Coordinate[10];

        coordinates[0] = new Coordinate(50, 30);
        coordinates[1] = new Coordinate(50, 50);
        coordinates[2] = new Coordinate(62, 50);
        coordinates[3] = new Coordinate(62, 41);
        coordinates[4] = new Coordinate(53, 41);
        coordinates[5] = new Coordinate(53, 30);
        coordinates[6] = new Coordinate(52, 48);
        coordinates[7] = new Coordinate(60, 48);
        coordinates[8] = new Coordinate(60, 43);
        coordinates[9] = new Coordinate(52, 43);

        return coordinates;
    }

    public static int[] getterRCodes() {
        final int[] codes = new int[12];

        codes[0] = 0;
        codes[1] = 1;
        codes[2] = 2;
        codes[3] = 3;
        codes[4] = 4;
        codes[5] = 5;
        codes[6] = 0;
        codes[7] = -6;
        codes[8] = 7;
        codes[9] = 8;
        codes[10] = 9;
        codes[11] = 6;

        return codes;
    }

    public static float[][] getRightHeartSide() {
        return new float[][]{{0f, -4.0f, 0.0f}, {4.0f, 0.5f, 0.0f}, {2.0f, 1.5f, 0.0f}, {0f, -0.5f, 0.0f}};
    }

    public static float[][] getLeftHeartSide() {
        return new float[][]{{0f, -4.0f, 0.0f}, {-4.0f, 0.5f, 0.0f}, {-2.0f, 1.5f, 0.0f}, {0f, -0.5f, 0.0f}};
    }

    public static float[] getHeartPoints() {
        return new float[]{0, 0, 0, 0, 1, 1, 1, 1};
    }

    public static float[] getRightHeartSideFlat() {
        return new float[]{0f, -4.0f, 0.0f, 4.0f, 0.5f, 0.0f, 2.0f, 1.5f, 0.0f, 0f, -0.5f, 0.0f};
    }

    public static float[] getLeftHeartSideFlat() {
        return new float[]{0f, -4.0f, 0.0f, -4.0f, 0.5f, 0.0f, -2.0f, 1.5f, 0.0f, 0f, -0.5f, 0.0f};
    }
}

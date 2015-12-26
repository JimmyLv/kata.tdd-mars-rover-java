public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position shift(Vector vector) {
        return new Position(preventBorder(x + vector.getX()), preventBorder(y + vector.getY()));
    }

    private int preventBorder(int value) {
        if (value < 0) {
            value = 0;
        } else if (value > 5) {
            value = 5;
        }
        return value;
    }

    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }
}

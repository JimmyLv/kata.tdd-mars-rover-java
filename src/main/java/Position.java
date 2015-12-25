public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }

    public void shift(Vector vector) {
        x += vector.getX();
        y += vector.getY();
    }
}

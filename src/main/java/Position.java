public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int offsetX, int offsetY) {
        this.x += offsetX;
        this.y += offsetY;
    }

    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }

    public void move(Vector vector) {
        this.x += vector.getX();
        this.y += vector.getY();
    }
}

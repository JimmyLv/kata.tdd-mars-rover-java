public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public void shift(Vector vector) {
        x += vector.getX();
        if (x < 0) {
            x = 0;
        }
        if (x > 5){
            x = 5;
        }
        y += vector.getY();
        if (y > 5){
            y = 5;
        }
    }

    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }
}

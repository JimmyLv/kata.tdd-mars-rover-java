import java.util.HashMap;

public class Position {
    public static final HashMap<Orientation, Vector> DIRECTIONS = new HashMap<Orientation, Vector>() {{
        put(Orientation.N, new Vector(0, 1));
        put(Orientation.E, new Vector(1, 0));
        put(Orientation.S, new Vector(0, -1));
        put(Orientation.W, new Vector(-1, 0));
    }};

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position shift(Orientation orientation) {
        Vector vector = DIRECTIONS.get(orientation);
        return new Position(preventBorder(x + vector.getX()), preventBorder(y + vector.getY()));
    }

    private int preventBorder(int value) {
        if (value < 0) return 0;
        if (value > 5) return 5;
        return value;
    }

    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }
}

import java.util.HashMap;

public class MarsRover {
    public static final HashMap<Orientation, Vector> DIRECTIONS = new HashMap<Orientation, Vector>() {{
        put(Orientation.N, new Vector(0, 1));
        put(Orientation.E, new Vector(1, 0));
        put(Orientation.S, new Vector(0, -1));
        put(Orientation.W, new Vector(-1, 0));
    }};
    public final HashMap<Character, Action> COMMANDS = new HashMap<Character, Action>() {{
        put('R', () -> orientation = orientation.right());
        put('L', () -> orientation = orientation.left());
        put('M', () -> position = position.shift(DIRECTIONS.get(orientation)));
        put('B', () -> position = position.shift(DIRECTIONS.get(orientation.right().right())));
    }};
    private Orientation orientation;
    private Position position;

    public MarsRover(int x, int y, String initialOrientation) {
        this.position = new Position(x, y);
        this.orientation = Orientation.valueOf(initialOrientation);
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            execute(command);
        }
    }

    private void execute(char command) {
        COMMANDS.get(command).act();
    }

    public String getPositionAndOrientation() {
        return position + " " + orientation;
    }
}

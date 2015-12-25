import java.util.HashMap;

public class MarsRover {
    public static final HashMap<String, Vector> DIRECTIONS = new HashMap<String, Vector>() {{
        put("N", new Vector(0, 1));
        put("W", new Vector(-1, 0));
        put("E", new Vector(1, 0));
        put("S", new Vector(0, -1));
    }};
    public static final HashMap<Character, Action> ACTIONS = new HashMap<Character, Action>() {{
        put('R', marsRover -> marsRover.orientation = marsRover.orientation.right());
        put('L', marsRover -> marsRover.orientation = marsRover.orientation.left());
        put('M', marsRover -> marsRover.position.shift(DIRECTIONS.get(marsRover.orientation.toString())));
    }};
    private Position position;
    private Orientation orientation;

    public MarsRover(Position position, String initialOrientation) {
        this.orientation = Orientation.valueOf(initialOrientation);
        this.position = position;
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            execute(command);
        }
    }

    private void execute(char command) {
        ACTIONS.get(command).act(this);
    }

    public String getPositionAndOrientation() {
        return position + " " + orientation;
    }
}

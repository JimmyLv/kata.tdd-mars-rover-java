import java.util.HashMap;
import java.util.function.Consumer;

public class MarsRover {
    public static final HashMap<Orientation, Vector> DIRECTIONS = new HashMap<Orientation, Vector>() {{
        put(Orientation.N, new Vector(0, 1));
        put(Orientation.E, new Vector(1, 0));
        put(Orientation.S, new Vector(0, -1));
        put(Orientation.W, new Vector(-1, 0));
    }};
    public static final HashMap<Character, Consumer<MarsRover>> COMMANDS = new HashMap<Character, Consumer<MarsRover>>() {{
        put('L', (marsRover) -> marsRover.orientation = marsRover.orientation.left());
        put('R', (marsRover) -> marsRover.orientation = marsRover.orientation.right());
        put('M', (marsRover) -> marsRover.position.move(DIRECTIONS.get(marsRover.orientation)));
    }};

    private Orientation orientation;
    private Position position;

    public MarsRover(int x, int y, String initialOrientation) {
        this.position = new Position(x, y);
        orientation = Orientation.valueOf(initialOrientation);
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            execute(command);
        }
    }

    private void execute(char command) {
        COMMANDS.get(command).accept(this);
    }

    public String getPositionAndOrientation() {
        return String.format("%s %s", this.position, orientation);
    }
}

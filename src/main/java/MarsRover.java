import java.util.ArrayList;
import java.util.HashMap;

public class MarsRover {

    private static final ArrayList<String> ORIENTATIONS = new ArrayList<String>() {{
        add("N");
        add("E");
        add("S");
        add("W");
    }};
    public static final HashMap<String, Vector> DIRECTIONS = new HashMap<String, Vector>() {{
        put("N", new Vector(0, 1));
        put("E", new Vector(1, 0));
        put("S", new Vector(0, -1));
        put("W", new Vector(-1, 0));
    }};
    public static final HashMap<Character, Action> COMMANDS = new HashMap<Character, Action>() {{
        put('R', (marsRover -> marsRover.rotateRight()));
        put('L', (marsRover -> marsRover.rotateLeft()));
        put('M', (marsRover -> marsRover.position.shift(DIRECTIONS.get(marsRover.orientation.toString()))));
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
        COMMANDS.get(command).act(this);
    }

    private void rotateLeft() {
        orientation = orientation.left();

    }

    private void rotateRight() {
        orientation = orientation.right();
    }

    public String getPositionAndOrientation() {
        return position + " " + orientation;
    }
}

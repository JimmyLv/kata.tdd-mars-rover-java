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
        put('M', (marsRover -> marsRover.moveForward()));
    }};
    private String orientation;
    private Position position;

    public MarsRover(int x, int y, String initialOrientation) {
        this.position = new Position(x, y);
        this.orientation = initialOrientation;
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            execute(command);
        }
    }

    private void execute(char command) {
        COMMANDS.get(command).act(this);
    }

    private void moveForward() {
        position.shift(DIRECTIONS.get(orientation));
    }

    private void rotateLeft() {
        int index = ORIENTATIONS.indexOf(orientation);
        int pre = index - 1;
        pre = pre < 0 ? ORIENTATIONS.size() + pre : pre;
        orientation = ORIENTATIONS.get(pre);
    }

    private void rotateRight() {
        int index = ORIENTATIONS.indexOf(orientation);
        int next = index + 1;
        next = next >= ORIENTATIONS.size() ? ORIENTATIONS.size() - next : next;
        orientation = ORIENTATIONS.get(next);
    }

    public String getPositionAndOrientation() {
        return position + " " + orientation;
    }
}

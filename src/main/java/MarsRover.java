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
    private String orientation;
    private Position position;

    public MarsRover(int x, int y, String initialOrientation) {
        this.position = new Position(x, y);
        this.orientation = initialOrientation;
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (isRightTurnCommand(command)) {
                rotateRight();
            } else if (isLeftTurnCommand(command)) {
                rotateLeft();
            } else {
                moveForward();
            }
        }
    }

    private boolean isLeftTurnCommand(char command) {
        return command == 'L';
    }

    private boolean isRightTurnCommand(char command) {
        return command == 'R';
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

    private void moveForward() {
        position.move(DIRECTIONS.get(orientation));
    }

    public String getPositionAndOrientation() {
        return String.format("%s %s", this.position, orientation);
    }
}

import java.util.ArrayList;

public class MarsRover {

    private static final ArrayList<String> ORIENTATIONS = new ArrayList<String>() {{
        add("N");
        add("E");
        add("S");
        add("W");
    }};
    private String orientation;
    private Position position;

    public MarsRover(Position position, String initialOrientation) {
        this.orientation = initialOrientation;
        this.position = position;
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

    private void rotateRight() {
        int index = ORIENTATIONS.indexOf(orientation);
        int next = index + 1;
        next = next >= ORIENTATIONS.size() ? ORIENTATIONS.size() - next : next;
        orientation = ORIENTATIONS.get(next);
    }

    private void moveForward() {
        switch (orientation) {
            case "N":
                position.shift(new Vector(0, 1));
                break;
            case "W":
                position.shift(new Vector(-1, 0));
                break;
            case "E":
                position.shift(new Vector(1, 0));
                break;
            case "S":
                position.shift(new Vector(0, -1));
                break;
        }
    }

    private void rotateLeft() {
        int index = ORIENTATIONS.indexOf(orientation);
        int pre = index - 1;
        pre = pre < 0 ? ORIENTATIONS.size() + pre : pre;
        orientation = ORIENTATIONS.get(pre);
    }

    public String getPositionAndOrientation() {
        return position + " " + orientation;
    }
}

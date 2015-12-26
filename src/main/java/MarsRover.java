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

    public MarsRover(String initialPosition, String initialOrientation) {
        String[] strings = initialPosition.split(" ");
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        position = new Position(x, y);
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

    private void moveForward() {
        if (orientation.equals("N")) {
            position.shift(0, 1);
        } else if (orientation.equals("W")) {
            position.shift(-1 , 0);
        } else if (orientation.equals("E")) {
            position.shift(1, 0);
        } else if (orientation.equals("S")) {
            position.shift(0, -1);
        }
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

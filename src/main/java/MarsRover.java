import java.util.ArrayList;

public class MarsRover {

    private static final ArrayList<String> ORIENTATIONS = new ArrayList<String>() {{
        add("N");
        add("E");
        add("S");
        add("W");
    }};
    private int y;
    private int x;
    private String orientation;
    private Position position;

    public MarsRover(String initialPosition, String initialOrientation) {
        String[] strings = initialPosition.split(" ");
        this.x = Integer.parseInt(strings[0]);
        this.y = Integer.parseInt(strings[1]);
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
        if (orientation.equals("N")) {
            this.y += 1;
            position.move(0, 1);
        } else if (orientation.equals("W")) {
            this.x -= 1;
            position.move(-1, 0);
        } else if (orientation.equals("E")) {
            this.x += 1;
            position.move(1, 0);
        } else if (orientation.equals("S")) {
            this.y -= 1;
            position.move(0, -1);
        }
    }

    public String getPositionAndOrientation() {
        return String.format("%s %s", this.position, orientation);
    }
}

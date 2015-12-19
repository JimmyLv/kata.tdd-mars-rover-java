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

    public MarsRover(String initialPosition, String initialOrientation) {
        String[] strings = initialPosition.split(" ");
        this.x = Integer.parseInt(strings[0]);
        this.y = Integer.parseInt(strings[1]);
        this.orientation = initialOrientation;
    }

    public void execute(String commands) {
        char[] chars = commands.toCharArray();

        for (char command : chars) {
            if (command == 'R') {
                int index = ORIENTATIONS.indexOf(orientation);
                int next = index + 1;
                next = next >= ORIENTATIONS.size() ? ORIENTATIONS.size() - next : next;
                orientation = ORIENTATIONS.get(next);
            } else if (command == 'L') {
                rotateLeft();
            } else {
                moveForward();
            }
        }
    }

    private void moveForward() {
        if (orientation.equals("N")) {
            this.y += 1;
        } else if (orientation.equals("W")) {
            this.x -= 1;
        } else if (orientation.equals("E")) {
            this.x += 1;
        }
    }

    private void rotateLeft() {
        int index = ORIENTATIONS.indexOf(orientation);
        int pre = index - 1;
        pre = pre < 0 ? ORIENTATIONS.size() + pre : pre;
        orientation = ORIENTATIONS.get(pre);
    }

    public String getPositionAndOrientation() {
        return this.x + " " + this.y + " " + orientation;
    }
}

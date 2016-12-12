import java.util.Arrays;
import java.util.HashMap;

public class MarsRover {
    private final HashMap<String, Action> COMMANDS = new HashMap<String, Action>() {{
        put("R", () -> orientation = orientation.right());
        put("L", () -> orientation = orientation.left());
        put("M", () -> position = position.shift(orientation));
        put("B", () -> position = position.shift(orientation.right().right()));
    }};

    private Orientation orientation;
    private Position position;

    public MarsRover(int x, int y, String initialOrientation) {
        this.position = new Position(x, y);
        this.orientation = Orientation.valueOf(initialOrientation);
    }

    public void execute(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(command -> COMMANDS.get(command).act());
    }

    public String status() {
        return position + " " + orientation;
    }

    @Override
    public String toString() {
        return String.format("MarsRover(%s %s)", position, orientation);
    }
}

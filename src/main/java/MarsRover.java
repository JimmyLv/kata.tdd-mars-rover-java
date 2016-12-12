import java.util.Arrays;
import java.util.HashMap;

public class MarsRover {
    private final HashMap<String, Runnable> COMMANDS = new HashMap<String, Runnable>() {{
        put("R", () -> orientation = orientation.right());
        put("L", () -> orientation = orientation.left());
        put("M", () -> position = position.shift(orientation));
        put("B", () -> position = position.shift(orientation.right().right()));
    }};

    private Orientation orientation;
    private Position position;

    public MarsRover(int x, int y, String orientation) {
        this.position = new Position(x, y);
        this.orientation = Orientation.valueOf(orientation);
    }

    public void execute(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(command -> COMMANDS.get(command).run());
    }

    public String status() {
        return position + " " + orientation;
    }

    @Override
    public String toString() {
        return String.format("MarsRover(%s %s)", position, orientation);
    }
}

import java.util.HashMap;

public class MarsRover {
    public final HashMap<Character, Action> COMMANDS = new HashMap<Character, Action>() {{
        put('R', () -> orientation = orientation.right());
        put('L', () -> orientation = orientation.left());
        put('M', () -> position = position.shift(orientation));
        put('B', () -> position = position.shift(orientation.right().right()));
    }};

    private Orientation orientation;
    private Position position;

    public MarsRover(int x, int y, String initialOrientation) {
        this.position = new Position(x, y);
        this.orientation = Orientation.valueOf(initialOrientation);
    }

    public void execute(String commands) {
        commands.chars()
                .mapToObj(command -> (char)command)
                .forEach(this::execute);
    }

    private void execute(char command) {
        COMMANDS.get(command).act();
    }

    public String status() {
        return position + " " + orientation;
    }
}

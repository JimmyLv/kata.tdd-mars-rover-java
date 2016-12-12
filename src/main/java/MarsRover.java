import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

public class MarsRover {
    private final HashMap<String, Function<Status, Status>> COMMANDS = new HashMap<String, Function<Status, Status>>() {{
        put("R", (status) -> new Status(status.getPosition(), status.getOrientation().right()));
        put("L", (status) -> new Status(status.getPosition(), status.getOrientation().left()));
        put("M", (status) -> new Status(status.getPosition().shift(status.getOrientation()), status.getOrientation()));
        put("B", (status) -> new Status(status.getPosition().shift(status.getOrientation().right().right()), status.getOrientation()));
    }};

    private Status status;

    public MarsRover(int x, int y, String orientation) {
        this.status = new Status(new Position(x, y), Orientation.valueOf(orientation));
    }

    public void execute(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(command -> this.status = COMMANDS.get(command).apply(this.status));
    }

    public Status status() {
        return this.status;
    }

    @Override
    public String toString() {
        return String.format("MarsRover(%s %s)", this.status.getPosition(), this.status.getOrientation());
    }
}

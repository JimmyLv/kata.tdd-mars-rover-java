public class MarsRover {

    private String orientation;

    public MarsRover(String initialPositionAndOrientation) {

    }

    public void execute(String command) {
        if (command.equals("R")) {
            orientation = "E";
        } else if (command.equals("L")) {
            orientation = "W";
        }
    }

    public String getPositionAndOrientation() {
        return "0 0 " + orientation;
    }
}

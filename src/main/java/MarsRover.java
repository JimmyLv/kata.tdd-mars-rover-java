public class MarsRover {

    private String orientation;

    public MarsRover(String initialPositionAndOrientation) {
        String[] strings = initialPositionAndOrientation.split(" ");
        this.orientation = strings[2];
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

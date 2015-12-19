public class MarsRover {

    private String orientation;
    private int y;

    public MarsRover(String initialPositionAndOrientation) {
        String[] strings = initialPositionAndOrientation.split(" ");
        this.y = Integer.parseInt(strings[1]);
        this.orientation = strings[2];
    }

    public void execute(String command) {
        if (command.equals("R")) {
            orientation = "E";
        } else if (command.equals("L")) {
            orientation = "W";
        } else {
            this.y += 1;
        }
    }

    public String getPositionAndOrientation() {
        return "0 " + this.y + " " + orientation;
    }
}

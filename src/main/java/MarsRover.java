public class MarsRover {

    private String orientation;
    private int y;
    private int x;

    public MarsRover(String initialPositionAndOrientation, String orientation) {
        String[] strings = initialPositionAndOrientation.split(" ");
        this.x = Integer.parseInt(strings[0]);
        this.y = Integer.parseInt(strings[1]);
        this.orientation = orientation;
    }

    public void execute(String command) {
        if (command.equals("R")) {
            orientation = "E";
        } else if (command.equals("L")) {
            orientation = "W";
        } else {
            if (orientation.equals("N")) {
                this.y += 1;
            } else if (orientation.equals("W")) {
                this.x -= 1;
            }
        }
    }

    public String getPositionAndOrientation() {
        return "0 " + this.y + " " + orientation;
    }
}

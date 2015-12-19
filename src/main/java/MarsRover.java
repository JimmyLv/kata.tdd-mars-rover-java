public class MarsRover {

    private int y;
    private int x;
    private String orientation;

    public MarsRover(String initialPosition, String initialOrientation) {
        String[] strings = initialPosition.split(" ");
        this.x = Integer.parseInt(strings[0]);
        this.y = Integer.parseInt(strings[1]);
        this.orientation = initialOrientation;
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

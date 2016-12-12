public class Status {
    private Orientation orientation;
    private Position position;


    public Status(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.position, this.orientation);
    }
}

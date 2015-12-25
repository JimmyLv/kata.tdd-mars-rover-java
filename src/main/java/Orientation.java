public enum Orientation {
    N(0), E(1), S(2), W(3);

    private int index;

    Orientation(int index) {

        this.index = index;
    }
    public Orientation left() {
        int pre = index - 1;
        return values()[pre < 0 ? values().length + pre : pre];
    }

    public Orientation right() {
        int pre = index + 1;
        return values()[pre > values().length ? values().length - pre : pre];
    }
}

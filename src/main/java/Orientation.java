public enum Orientation {
    N(0), E(1), S(2), W(3);

    private int index;

    Orientation(int index) {
        this.index = index;
    }

    public Orientation left() {
        int pre = index - 1;
        return pre < 0 ? values()[values().length + pre] : values()[pre];
    }

    public Orientation right() {
        int next = index + 1;
        return next >= values().length ? values()[next - values().length] : values()[next];
    }
}

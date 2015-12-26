public enum Orientation {
    N, E, S, W;

    public Orientation left() {
        int pre = ordinal() - 1;
        if (pre < 0) {
            return values()[values().length + pre];
        } else {
            return values()[pre];
        }
    }

    public Orientation right() {
        int next = ordinal() + 1;
        if (next >= values().length) {
            return values()[next - values().length];
        } else {
            return values()[next];
        }
    }
}

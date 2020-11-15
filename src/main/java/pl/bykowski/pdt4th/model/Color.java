package pl.bykowski.pdt4th.model;

public enum Color {
    BLACK("black"),
    WHITE("white"),
    RED("red"),
    BLUE("blue"),
    GREEN("green"),
    YELLOW("yellow"),
    GRAY("gray"),
    BROWN("brown"),
    PINK("pink"),
    PURPLE("purple"),
    SILVER("silver"),
    GOLDEN("golden");

    Color(String name) {
    }

    @Override
    public String toString() {
        return name();
    }
}

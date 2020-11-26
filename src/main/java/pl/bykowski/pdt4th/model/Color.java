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

    private final String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

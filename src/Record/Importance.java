package Record;

public enum Importance {
    Recovery_Normal(1, "."), Warning(2, "!"), Serious_Error(3, "!!!"), Critical_Error(4, "!!!!");
    private int value;
    private String symbol;

    Importance(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {

        return value;
    }
}
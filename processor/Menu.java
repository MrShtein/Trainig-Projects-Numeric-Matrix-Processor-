package processor;

public enum Menu {

    FIRST("1", "Add Matrices"),
    SECOND("2", "Multiply matrix by a constant"),
    THIRD("3", "Multiply matrices"),
    FOURTH("4", "Transpose matrix"),
    FIFTH("5", "Calculate a determinant"),
    SIXTH("6", "Inverse matrix"),
    ZERO("0", "Exit");

    private String menuNumber;
    private String menuText;

    Menu(String menuNumber, String menuText) {
        this.menuNumber = menuNumber;
        this.menuText = menuText;
    }

    public String getMenuNumber() {
        return menuNumber;
    }

    public String getMenuText() {
        return menuText;
    }
}

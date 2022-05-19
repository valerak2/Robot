package gui.menu;

import gui.localization.Language;

enum Colors {
    Red(Language.rb.getString("RED")),
    Green(Language.rb.getString("GREEN")),
    Blue(Language.rb.getString("BLUE")),
    Orange(Language.rb.getString("ORANGE")),
    Magenta(Language.rb.getString("MAGENTA")),
    Gray(Language.rb.getString("GRAY")),
    Cyan(Language.rb.getString("CYAN")),
    Pink(Language.rb.getString("PINK")),
    White(Language.rb.getString("WHITE")),
    Yellow(Language.rb.getString("YELLOW")),
    Light_Gray(Language.rb.getString("LIGHT_GRAY"));
    private String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColors(String color) {
        this.color = color;
    }
}

package model;

public class Produktumgebung {

    private String text;

    public Produktumgebung() {
        this.text = "";
    }

    public Produktumgebung(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

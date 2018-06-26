package model;

public class Zielbestimmung {

    private String text;

    public Zielbestimmung() {
        this.text = "";
    }

    public Zielbestimmung(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

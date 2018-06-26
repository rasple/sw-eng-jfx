package model;

public class Produkteinsatz {
    private String text;

    public Produkteinsatz() {
        this.text = "";
    }

    public Produkteinsatz(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

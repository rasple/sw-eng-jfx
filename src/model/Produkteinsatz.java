package model;

import java.io.Serializable;

public class Produkteinsatz implements Serializable {
    private String text;

    public Produkteinsatz() {
        this.text = "";
    }

    public Produkteinsatz(String text) {
        this.text = text;
    }

    public Produkteinsatz(Produkteinsatz produkteinsatz) {
        this.text = produkteinsatz.text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Produkteinsatz{" +
                "text='" + text + '\'' +
                '}';
    }
}

package model;

import java.io.Serializable;

public class Zielbestimmung implements Serializable {

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

    @Override
    public String toString() {
        return "Zielbestimmung{" +
                "text='" + text + '\'' +
                '}';
    }
}

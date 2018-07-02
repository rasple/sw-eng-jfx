package model;

import java.io.Serializable;

public class Produktumgebung implements Serializable {

    private String text;

    public Produktumgebung() {
        this.text = "";
    }

    public Produktumgebung(String text) {
        this.text = text;
    }

    public Produktumgebung(Produktumgebung produktumgebung) {
        this.text = produktumgebung.text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Produktumgebung{" +
                "text='" + text + '\'' +
                '}';
    }
}

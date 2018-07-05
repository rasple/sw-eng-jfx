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

    public Zielbestimmung(Zielbestimmung zielbestimmung) {
        this.text = zielbestimmung.text;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj instanceof Zielbestimmung) {
            Zielbestimmung other = (Zielbestimmung) obj;

            if(!this.text.equals(other.text)) {return false;}

            return true;
        }
        return false;
    }
}

package model;

import java.io.Serializable;

public class Produktumgebung implements Serializable, Produktumgebung_I {

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj instanceof Produktumgebung) {
            Produktumgebung other = (Produktumgebung) obj;

            if(!this.text.equals(other.text)) {return false;}

            return true;
        }
        return false;
    }
}

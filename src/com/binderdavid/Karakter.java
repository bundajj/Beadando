package com.binderdavid;

public abstract class Karakter {

    private int eletero;
    private int pozicio;

    public Karakter() {
        eletero = (int) (Math.random() * 6 + 4); // d6+3 életerő
        pozicio = (int) (Math.random() * 3);
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getPozicio() {
        return pozicio;
    }

    public void setPozicio(int pozicio) {
        this.pozicio = pozicio;
    }
    public abstract String getNev();
    public void lep() {
        int lepes = (int) (Math.random() * 3);
        this.pozicio = lepes ;
    }

    public void serul(int sebzes) {
        this.eletero -= sebzes;
        if (this.eletero < 0) {
            this.eletero = 0;
        }
    }
}


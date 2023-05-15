package com.binderdavid;

public  class Karakter {
    private String nev;
    private int eletero;
    private int pozicio;

    public Karakter(String name ) {
        eletero = (int) (Math.random() * 6 + 4);
        pozicio = (int) (Math.random() * 3);
        this.nev =name;
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

    public String getNev() {
        return nev;
    }

    public void setPozicio(int pozicio) {
        this.pozicio = pozicio;
    }

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


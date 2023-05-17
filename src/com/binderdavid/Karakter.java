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



    public int getPozicio() {
        return pozicio;
    }

    public String getNev() {
        return nev;
    }



    public void lep() {
        this.pozicio = (int) (Math.random() * 3);
    }

    public void serul(int sebzes) {
        this.eletero -= sebzes;
        if (this.eletero < 0) {
            this.eletero = 0;
        }
    }
}


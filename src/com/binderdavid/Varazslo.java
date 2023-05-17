package com.binderdavid;

public class Varazslo extends Karakter implements Pajzsos {
    private int vedelem;
    public Varazslo() {

        super("V");
        this.vedelem=(int) (Math.random() *1);
    }


    @Override
    public boolean ved(int sebzes) {
        if (this.vedelem>=sebzes){


        }
        return false;
    }
}

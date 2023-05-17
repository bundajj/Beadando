package com.binderdavid;

public class Harcos extends Karakter implements Pajzsos {

    private int vedelem;
    public Harcos() {
        super("H");
        this.vedelem=(int) (Math.random() *2);
    }


    @Override
    public boolean ved(int sebzes) {
        if (this.vedelem>=sebzes){

            return true;
        }
        return false;
    }
}

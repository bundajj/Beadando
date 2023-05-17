package com.binderdavid;

public class Varazslo extends Karakter implements Pajzsos {
    private int vedelemVarazslat;
    public Varazslo() {

        super("V");
        this.vedelemVarazslat=(int) (Math.random() *2);
    }


    @Override
    public boolean ved(int sebzes) {
        if (this.vedelemVarazslat>=sebzes){
            return true;

        }
        return false;
    }
}

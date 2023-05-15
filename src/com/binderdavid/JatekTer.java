package com.binderdavid;

public class JatekTer {
  private Karakter[] karakterek;


    public JatekTer() {
        this.karakterek = new Karakter[2];
        karakterek[0]=new Harcos();
        karakterek[1]=new Varazslo();
    }
}

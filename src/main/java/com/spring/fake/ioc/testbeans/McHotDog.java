package com.spring.fake.ioc.testbeans;

/**
 * Created by tnpla on 2019/1/21.
 */
public class McHotDog {

    private String song;
    private Rapper rapper;

    public void setSong(String song) {
        this.song = song;
    }

    public void setRapper(Rapper rapper) {
        this.rapper = rapper;
    }

    public Rapper getRapper() {
        return rapper;
    }

    public void sing() {
        System.out.println("I'm MC_HotDog, let me rap the " + song);
    }
}

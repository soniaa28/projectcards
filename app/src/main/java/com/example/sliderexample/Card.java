package com.example.sliderexample;

public class Card {
    private int id;
    private String state;
    private int tf;


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", tf='" + tf + '\''+
           '}';
    }


    public Card(int id, String state, int tf) {
        this.id = id;
        this.state = state;
        this.tf = tf;

    }
    public Card(String state, int tf) {
        this.state = state;
        this.tf= tf;


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getState() {
        return state;
    }

    public void setState(String name) {
        this.state= state;
    }

    public int getTF() {
        return tf;
    }

    public void setTf(String number) {
        this.tf = tf;
    }



}

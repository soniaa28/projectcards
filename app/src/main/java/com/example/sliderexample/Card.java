package com.example.sliderexample;

public class Card {
    private int id;
    private String state;
    private int tf;
    private String topic;
    private String rule;


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", tf='" + tf + '\'' +
                ", topic='" + topic + '\'' +
                ", rule='" + rule + '\'' +
                '}';
    }


    public Card(int id, String state, int tf, String topic, String rule) {
        this.id = id;
        this.state = state;
        this.tf = tf;
        this.topic = topic;
        this.rule = rule;

    }


    public Card(String state, int tf, String topic, String rule) {
        this.state = state;
        this.tf = tf;
        this.topic = topic;
        this.rule = rule;


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
        this.state = state;
    }

    public int getTF() {
        return tf;
    }

    public void setTf(String number) {
        this.tf = tf;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }


}
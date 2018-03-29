package com.jh.queueueues.api;

public class ThingTwo {

    static int seq;
    int seqnum;
    {

        this.seqnum = seq++;
    }
    public ThingTwo() {
    }
    public String toString() {
        return "ThingTwo{" + seqnum + "}";

    }
}

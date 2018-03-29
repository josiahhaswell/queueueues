package com.jh.queueueues.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ThingOne {

    static int seq;
    int seqnum;

    {
        this.seqnum = seq++;
    }
    public ThingOne() {
    }
    public String toString() {
        return "ThingTwo{" + seqnum + "}";

    }
}

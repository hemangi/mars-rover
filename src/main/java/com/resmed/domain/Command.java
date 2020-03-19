package com.resmed.domain;

public enum Command {
    P("Place"),
    M("Move"),
    L("Left"),
    R("Right"),
    C("Report");

    private String comm;
    Command(String comm) {

    }
}

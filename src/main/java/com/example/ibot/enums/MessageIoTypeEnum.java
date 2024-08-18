package com.example.ibot.enums;

public enum MessageIoTypeEnum {

    INPUT("输入"),
    OUTPUT("输出");

    private String desc;

    MessageIoTypeEnum(String desc) {
        this.desc = desc;
    }

}

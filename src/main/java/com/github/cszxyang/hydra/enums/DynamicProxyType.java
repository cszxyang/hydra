package com.github.cszxyang.hydra.enums;

import lombok.Getter;

public enum DynamicProxyType {

    CGLIB(0),
    JDK_PROXY(1),
    ;

    @Getter
    private int type;

    DynamicProxyType(int type) {
        this.type = type;
    }
}

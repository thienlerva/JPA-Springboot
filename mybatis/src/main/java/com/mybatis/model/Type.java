package com.mybatis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {

    @JsonProperty("Checking")
    Checking,
    @JsonProperty("Saving")
    Saving,
    @JsonProperty("CD")
    CD
}

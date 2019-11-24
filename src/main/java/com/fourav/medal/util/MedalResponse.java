package com.fourav.medal.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties( ignoreUnknown = true )
public class MedalResponse implements Serializable {

    private List<MedalObject> contentObjects;

    public List<MedalObject> getContentObjects() {
        return contentObjects;
    }

    public void setContentObjects(List<MedalObject> contentObjects) {
        this.contentObjects = contentObjects;
    }
}

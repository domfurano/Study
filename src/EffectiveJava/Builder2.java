package EffectiveJava;

import java.lang.reflect.AccessibleObject;
import java.util.EnumSet;
import java.util.Objects;

class Builder2 {
    public Builder2(Integer f) {
        Objects.requireNonNull(f);
//        EnumSet.noneOf()
        AccessibleObject.setAccessible();
    }
}
package com.java.pattern.functional.factorypattern;

import java.util.Objects;
import java.util.function.Supplier;

class Container<T> {

    private final Supplier<? extends T> ctor;

    private T field;

    Container(Supplier<? extends T> ctor) {
        this.ctor = Objects.requireNonNull(ctor);
    }

    public void access() {
        field = ctor.get();
    }

    public T getField() {
        return field;
    }
}


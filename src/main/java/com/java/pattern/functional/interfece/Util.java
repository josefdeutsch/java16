package com.java.pattern.functional.interfece;

import java.util.function.Function;

public final class Util {

    public <T> T add(T t,  Function<T, T> fn){
        return fn.apply(t);
    }

}

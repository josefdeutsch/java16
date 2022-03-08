package com.java.pattern.functional;

@FunctionalInterface
public interface ShortToByteFunction {

    byte applyAsByte(short s);

    static byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }
}

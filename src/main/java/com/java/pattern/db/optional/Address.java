package com.java.pattern.db.optional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public final class Address<A,B,C> {

    private final A a;
    private final B b;
    private final C c;

    @SuppressWarnings({"unchecked"})
    public Address(
            @NotNull A a,
            @NotNull B b,
            @Nullable C c){

        this.a =
                (A) Objects.requireNonNullElse(
                        a,
                        "com.java.pattern.db.optional.Address.addressLine must not be null");

        this.b =
                (B) Objects.requireNonNullElse(
                        b,
                        "com.java.pattern.db.optional.Address.addressLine must not be null");

        this.c =
                c;
    }

    public @NotNull B getAddressLine() {
        return b; }

    public @NotNull C getCity() {
        return c; }

    public  @NotNull Optional<? extends C> getPostcode() {
        return Optional.ofNullable(c);
    }

    public static <T> @NotNull Optional<? super T> findAddress(
            @Nullable T t) {
        return Optional.ofNullable(t);
    }
}

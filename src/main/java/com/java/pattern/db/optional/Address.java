package com.java.pattern.db.optional;

import java.util.Objects;
import java.util.Optional;

public final class Address {
    private final String addressLine;  // never null
    private final String city;         // never null
    private final String postcode;     // optional, thus may be null

    // constructor ensures non-null fields really are non-null
    // optional field can just be stored directly, as null means optional
    public Address(String addressLine, String city, String postcode) {
        this.addressLine = Objects.requireNonNull(addressLine);
        this.city = Objects.requireNonNull(city);
        this.postcode = postcode;
    }

    // normal getters
    public String getAddressLine() { return addressLine; }
    public String getCity() { return city; }

    // special getter for optional field
    public Optional<String> getPostcode() {
        return Optional.ofNullable(postcode);
    }

    // return optional instead of null for business logic methods that may not find a result
    public static <T> Optional<T> findAddress(T t) {
        return Optional.ofNullable(t);
        // find the address, returning Optional.empty() if not found
    }
}

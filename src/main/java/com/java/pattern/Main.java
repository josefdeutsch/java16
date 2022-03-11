package com.java.pattern;

import com.java.pattern.db.optional.Address;
import com.java.pattern.generics.Box;
import com.java.pattern.generics.Letter;
import com.java.pattern.generics.Phone;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        Address address =
                new Address(
                        null,
                        "uschi",
                        null);

        System.out.println(address.getAddressLine());
        System.out.println(address.getCity());
        System.out.println(address.getPostcode());

    }
}

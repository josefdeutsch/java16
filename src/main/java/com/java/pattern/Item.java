package com.java.pattern;


public final class Item {


        private final int value;

        public Item(final int value) {

            this.value = value;
        }

        public boolean isQualified() {

            return value % 2 == 0;
        }

        public void operate() {

        }
    }


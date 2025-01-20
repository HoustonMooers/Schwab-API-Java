package com.hm.schwab.datastructs.query.marketdata;

public enum Frequency {
	n0("0"),
	n1("1"),
	n5("5"),
	n10("10"),
	n30("30"),
	n60("60");

    private final String label;

    Frequency(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

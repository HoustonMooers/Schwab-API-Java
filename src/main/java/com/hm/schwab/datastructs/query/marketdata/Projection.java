package com.hm.schwab.datastructs.query.marketdata;

public enum Projection {
	SymbolSearch("symbol-search"),
	SearchRegex("symbol-regex"),
	DescSearch("desc-search"),
	DescRegex("desc-regex"),
	Search("search"),
	Fundamental("fundamental");

    private final String label;

	Projection(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

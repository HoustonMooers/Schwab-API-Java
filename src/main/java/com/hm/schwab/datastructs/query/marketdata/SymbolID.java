package com.hm.schwab.datastructs.query.marketdata;

public enum SymbolID {
	DOW("$DJI"),
	COMP("$COMPX"),
	SPX("$SPX"),
	NYSE("NYSE"),
	NASDAQ("NASDAQ"),
	OTCBB("OTCBB"),
	INDEX_ALL("INDEX_ALL"),
	EQUITY_ALL("EQUITY_ALL"),
	OPTION_ALL("OPTION_ALL"),
	OPTION_PUT("OPTION_PUT"),
	OPTION_CALL("OPTION_CALL");

    private final String label;

    SymbolID(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

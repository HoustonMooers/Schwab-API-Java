package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Enums {
	public enum Session {
	    NORMAL, AM, PM, SEAMLESS, EXTO
	}

	public enum Duration {
	    DAY, GOOD_TILL_CANCEL, FILL_OR_KILL, IMMEDIATE_OR_CANCEL, END_OF_WEEK, END_OF_MONTH, NEXT_END_OF_MONTH, UNKNOWN
	}

	public enum OrderType {
	    MARKET, LIMIT, STOP, STOP_LIMIT, TRAILING_STOP, CABINET, NON_MARKETABLE, MARKET_ON_CLOSE, EXERCISE, TRAILING_STOP_LIMIT, NET_DEBIT, NET_CREDIT, NET_ZERO, LIMIT_ON_CLOSE, UNKNOWN
	}

	public enum ComplexOrderStrategyType {
	    NONE, COVERED, VERTICAL, BACK_RATIO, CALENDAR, DIAGONAL, STRADDLE, STRANGLE, COLLAR_SYNTHETIC, BUTTERFLY, CONDOR, IRON_CONDOR, VERTICAL_ROLL, COLLAR_WITH_STOCK, DOUBLE_DIAGONAL, UNBALANCED_BUTTERFLY, UNBALANCED_CONDOR, UNBALANCED_IRON_CONDOR, UNBALANCED_VERTICAL_ROLL, MUTUAL_FUND_SWAP, CUSTOM
	}

	public enum RequestedDestination {
	    INET, ECN_ARCA, CBOE, AMEX, PHLX, ISE, BOX, NYSE, NASDAQ, BATS, C2, AUTO
	}
	
	public enum OrderTypeRequest { 
		MARKET, LIMIT, STOP, STOP_LIMIT, TRAILING_STOP, CABINET, NON_MARKETABLE, MARKET_ON_CLOSE, EXERCISE, TRAILING_STOP_LIMIT, NET_DEBIT, NET_CREDIT, NET_ZERO, LIMIT_ON_CLOSE 
	}

	public enum StopPriceLinkBasis {
	    MANUAL, BASE, TRIGGER, LAST, BID, ASK, ASK_BID, MARK, AVERAGE
	}

	public enum StopPriceLinkType {
	    VALUE, PERCENT, TICK
	}

	public enum StopType {
	    STANDARD, BID, ASK, LAST, MARK
	}

	public enum PriceLinkBasis {
	    MANUAL, BASE, TRIGGER, LAST, BID, ASK, ASK_BID, MARK, AVERAGE
	}

	public enum PriceLinkType {
	    VALUE, PERCENT, TICK
	}

	public enum TaxLotMethod {
	    FIFO, LIFO, HIGH_COST, LOW_COST, AVERAGE_COST, SPECIFIC_LOT, LOSS_HARVESTER
	}

	public enum OrderLegType {
	    EQUITY, OPTION, INDEX, MUTUAL_FUND, CASH_EQUIVALENT, FIXED_INCOME, CURRENCY, COLLECTIVE_INVESTMENT
	}

	public enum Instruction {
	    BUY, SELL, BUY_TO_COVER, SELL_SHORT, BUY_TO_OPEN, BUY_TO_CLOSE, SELL_TO_OPEN, SELL_TO_CLOSE, EXCHANGE
	}

	public enum QuantityType {
	    ALL_SHARES, DOLLARS, SHARES
	}

	public enum DivCapGains {
	    REINVEST, PAYOUT
	}

	public enum SpecialInstruction {
	    ALL_OR_NONE, DO_NOT_REDUCE, ALL_OR_NONE_DO_NOT_REDUCE
	}

	public enum OrderStrategyType {
	    SINGLE, CANCEL, RECALL, PAIR, FLATTEN, TWO_DAY_SWAP, BLAST_ALL, OCO, TRIGGER
	}

	public enum Status {
	    VALID, INVALID, PENDING, AWAITING_PARENT_ORDER, AWAITING_CONDITION, AWAITING_STOP_CONDITION, AWAITING_MANUAL_REVIEW, ACCEPTED, AWAITING_UR_OUT, PENDING_ACTIVATION, QUEUED, WORKING, REJECTED, PENDING_CANCEL, CANCELED, PENDING_REPLACE, REPLACED, FILLED, EXPIRED, NEW, AWAITING_RELEASE_TIME, PENDING_ACKNOWLEDGEMENT, PENDING_RECALL, UNKNOWN
	}

	public enum ExecutionType {
	    FILL, CANCELED
	}

	public enum ApiCurrencyType {
	    USD, CAD, EUR, JPY
	}

	public enum AssetType {
	    EQUITY, MUTUAL_FUND, OPTION, FUTURE, FOREX, INDEX, CASH_EQUIVALENT, FIXED_INCOME, PRODUCT, CURRENCY, COLLECTIVE_INVESTMENT
	}

	public enum PutCall {
	    PUT, CALL, UNKNOWN
	}

	public enum OptionType {
	    VANILLA, BINARY, BARRIER, UNKNOWN
	}

	public enum TransactionType {
	    TRADE, RECEIVE_AND_DELIVER, DIVIDEND_OR_INTEREST, ACH_RECEIPT, ACH_DISBURSEMENT, CASH_RECEIPT, CASH_DISBURSEMENT, ELECTRONIC_FUND, WIRE_OUT, WIRE_IN, JOURNAL, MEMORANDUM, MARGIN_CALL, MONEY_MARKET, SMA_ADJUSTMENT
	}

	public enum SubAccount {
	    CASH, MARGIN, SHORT, DIV, INCOME, UNKNOWN
	}

	public enum ActivityType {
	    ACTIVITY_CORRECTION, EXECUTION, ORDER_ACTION, TRANSFER, UNKNOWN
	}

	public enum FeeType {
	    COMMISSION, SEC_FEE, STR_FEE, R_FEE, CDSC_FEE, OPT_REG_FEE, ADDITIONAL_FEE, MISCELLANEOUS_FEE, FUTURES_EXCHANGE_FEE, LOW_PROCEEDS_COMMISSION, BASE_CHARGE, GENERAL_CHARGE, GST_FEE, TAF_FEE, INDEX_OPTION_FEE, UNKNOWN
	}

	public enum PositionEffect {
	    OPENING, CLOSING, AUTOMATIC, UNKNOWN
	}

    public enum ExpirationType {
        M, Q, S, W
    }

    public enum SettlementType {
        A, P
    }

    public enum Direction {
        UP, DOWN
    }

    public enum MarketType {
        BOND, EQUITY, ETF, EXTENDED, FOREX, FUTURE, FUTURE_OPTION, FUNDAMENTAL, INDEX, INDICATOR, MUTUAL_FUND, OPTION, UNKNOWN
    }

    public enum AssetMainType {
        BOND, EQUITY, FOREX, FUTURE, FUTURE_OPTION, INDEX, MUTUAL_FUND, OPTION
    }

    public enum EquityAssetSubType {
        COE, PRF, ADR, GDR, CEF, ETF, ETN, UIT, WAR, RGT
    }

    public enum QuoteType {
        NBBO, NFL
    }

    public enum DivFreq {
    	NO_DIVIDEND(0),
        ANNUALLY(1),
        SEMI_ANNUALLY(2),
        THREE_TIMES_A_YEAR(3),
        QUARTERLY(4),
        EVERY_OTHER_MONTH(6),
        ELEVEN_TIMES_A_YEAR(11),
        MONTHLY(12);

        private final int value;

        // Constructor to set the integer value for each constant
        DivFreq(int value) {
            this.value = value;
        }

        // Optional: For serialization, tell Jackson to use this value
        @JsonValue
        public int getValue() {
            return value;
        }

        // For deserialization, map the JSON integer to the enum constant
        @JsonCreator
        public static DivFreq fromValue(int value) {
            for (DivFreq freq : DivFreq.values()) {
                if (freq.value == value) {
                    return freq;
                }
            }
            throw new IllegalArgumentException("Unknown dividend frequency value: " + value);
        }
    }

    public enum FundStrategy {
        @JsonProperty("A")
        ACTIVE,
        @JsonProperty("L")
        LEVERAGED,
        @JsonProperty("P")
        PASSIVE,
        @JsonProperty("Q")
        QUANTITATIVE,
        @JsonProperty("S")
        SHORT
    }

    public enum ExerciseType {
        A, E
    }

    public enum ContractType {
        P, C
    }

    public enum MutualFundAssetSubType {
        OEF, CEF, MMF
    }
}

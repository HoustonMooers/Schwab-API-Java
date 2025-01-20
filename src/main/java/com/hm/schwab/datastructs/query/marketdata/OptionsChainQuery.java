package com.hm.schwab.datastructs.query.marketdata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OptionsChainQuery {
	private String symbol;
	private ContractType contracttype;
	private int strikeCount;
	private Boolean underlyingquote;
	private OptionStrategy optionstrategy;
	private Integer interval;
	private Integer strike;
	private RangeType range;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Double volatility;
	private Double underlyingPrice;
	private Double interestRate;
	private Integer daysToExpiration;
	private ExpirationMonth expMonth;
	private String optionType; //not sure what this is for
	private Entitlement entitlement;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public OptionsChainQuery(String symbol) {
		this.symbol = symbol;
	}

	public ContractType getContracttype() {
		return contracttype;
	}

	public void setContracttype(ContractType contracttype) {
		this.contracttype = contracttype;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}

	public Boolean getUnderlyingquote() {
		return underlyingquote;
	}

	public void setUnderlyingquote(Boolean underlyingquote) {
		this.underlyingquote = underlyingquote;
	}

	public OptionStrategy getOptionstrategy() {
		return optionstrategy;
	}

	public void setOptionstrategy(OptionStrategy optionstrategy) {
		this.optionstrategy = optionstrategy;
	}

	public Integer getStrike() {
		return strike;
	}

	public void setStrike(Integer strike) {
		this.strike = strike;
	}

	public RangeType getRange() {
		return range;
	}

	public void setRange(RangeType range) {
		this.range = range;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Double getVolatility() {
		return volatility;
	}

	public void setVolatility(Double volatility) {
		this.volatility = volatility;
	}

	public Double getUnderlyingPrice() {
		return underlyingPrice;
	}

	public void setUnderlyingPrice(Double underlyingPrice) {
		this.underlyingPrice = underlyingPrice;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getDaysToExpiration() {
		return daysToExpiration;
	}

	public void setDaysToExpiration(Integer daysToExpiration) {
		this.daysToExpiration = daysToExpiration;
	}

	public ExpirationMonth getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(ExpirationMonth expMonth) {
		this.expMonth = expMonth;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public Entitlement getEntitlement() {
		return entitlement;
	}

	public void setEntitlement(Entitlement entitlement) {
		this.entitlement = entitlement;
	}

	public String getURI(String baseuri) {
		StringBuilder sb = new StringBuilder(baseuri);
		sb.append("chains?symbol=");
		sb.append(symbol);

		if(contracttype != null) {
			sb.append("&contractType=");
			sb.append(contracttype);
		}

		if(strikeCount != 0) {
			sb.append("&strikeCount=");
			sb.append(strikeCount);
		}

		if(underlyingquote != null) {
			sb.append("&includeUnderlyingQuote=");
			sb.append(underlyingquote);
		}

		if(optionstrategy != null) {
			sb.append("&strategy=");
			sb.append(optionstrategy);
		}

		if(optionstrategy != null) {
			sb.append("&strategy=");
			sb.append(optionstrategy);
		}

		if(interval != null) {
			sb.append("&interval=");
			sb.append(interval);
		}

		if(strike != null) {
			sb.append("&strike=");
			sb.append(strike);
		}

		if(range != null) {
			sb.append("&range=");
			sb.append(range);
		}

		if(fromDate != null) {
			sb.append("&fromDate=");
			sb.append(formatter.format(fromDate));
		}

		if(toDate != null) {
			sb.append("&toDate=");
			sb.append(formatter.format(toDate));
		}

		if(volatility != null) {
			sb.append("&volatility=");
			sb.append(volatility);
		}

		if(underlyingPrice != null) {
			sb.append("&underlyingPrice=");
			sb.append(underlyingPrice);
		}

		if(interestRate != null) {
			sb.append("&interestRate=");
			sb.append(interestRate);
		}

		if(daysToExpiration != null) {
			sb.append("&daysToExpiration=");
			sb.append(daysToExpiration);
		}

		if(expMonth != null) {
			sb.append("&expMonth=");
			sb.append(expMonth);
		}

		if(optionType != null) {
			sb.append("&optionType=");
			sb.append(optionType);
		}

		if(entitlement != null) {
			sb.append("&entitlement=");
			sb.append(entitlement);
		}
		return sb.toString();
	}
}

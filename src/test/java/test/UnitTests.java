package test;

import static org.junit.Assert.assertNotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hm.schwab.clientinterface.SchwabAPI;
import com.hm.schwab.datastructs.query.account.OrderByID;
import com.hm.schwab.datastructs.query.account.OrderQuery;
import com.hm.schwab.datastructs.query.marketdata.FrequencyType;
import com.hm.schwab.datastructs.query.marketdata.HistoricalDataQuery;
import com.hm.schwab.datastructs.query.marketdata.InstrumentSearchQuery;
import com.hm.schwab.datastructs.query.marketdata.Market;
import com.hm.schwab.datastructs.query.marketdata.MarketHoursQuery;
import com.hm.schwab.datastructs.query.marketdata.MarketMoversQuery;
import com.hm.schwab.datastructs.query.marketdata.OptionsChainQuery;
import com.hm.schwab.datastructs.query.marketdata.PeriodType;
import com.hm.schwab.datastructs.query.marketdata.Projection;
import com.hm.schwab.datastructs.query.marketdata.QuoteQuery;
import com.hm.schwab.datastructs.query.marketdata.RangeType;
import com.hm.schwab.datastructs.query.marketdata.SingleQuoteQuery;
import com.hm.schwab.datastructs.query.marketdata.SymbolID;
import com.hm.schwab.datastructs.schwab.Account;
import com.hm.schwab.datastructs.schwab.AccountEquity;
import com.hm.schwab.datastructs.schwab.AccountOption;
import com.hm.schwab.datastructs.schwab.AccountsInstrument;
import com.hm.schwab.datastructs.schwab.CandleList;
import com.hm.schwab.datastructs.schwab.ExpirationChain;
import com.hm.schwab.datastructs.schwab.Instrument;
import com.hm.schwab.datastructs.schwab.InstrumentResponse;
import com.hm.schwab.datastructs.schwab.MarketHours;
import com.hm.schwab.datastructs.schwab.OptionChain;
import com.hm.schwab.datastructs.schwab.OptionContract;
import com.hm.schwab.datastructs.schwab.Order;
import com.hm.schwab.datastructs.schwab.OrderLegCollection;
import com.hm.schwab.datastructs.schwab.QuoteResponse;
import com.hm.schwab.datastructs.schwab.Screeners;
import com.hm.schwab.datastructs.schwab.Enums.Duration;
import com.hm.schwab.datastructs.schwab.Enums.Instruction;
import com.hm.schwab.datastructs.schwab.Enums.OrderStrategyType;
import com.hm.schwab.datastructs.schwab.Enums.OrderType;
import com.hm.schwab.datastructs.schwab.Enums.Session;

public class UnitTests {
	private SchwabAPI api;

	public UnitTests() {
		try {
			this.api = new SchwabAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void accountTests() {
		//positions
		getAccountPositions();

		//orders
		getOrders();
		//cancelOrder();

		//do not blindly enable these orders on a production account...
		//runPlaceOrderTests();
	}

	private void cancelOrder() {
		OrderByID query = new OrderByID(1002488075304l);
		try {
			api.cancelOrder(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getOrders() {
		OrderQuery query = new OrderQuery(LocalDateTime.now().minusMonths(1), LocalDateTime.now());
		try {
			List<Order> orders = api.getOrders(query);
			assertNotNull(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getAccountPositions() {
		try {
			List<Account> positions = api.getAccountPositions();
			assertNotNull(positions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void marketDataTests() {
		//quotes
		getQuotes();
		getSingleQuote();

		//options
		getOptionExpirations();
		getOptionsChains();
		getOptionsChainsNTM();
		getOptionsChainNTMByDateRange();

		//historical data
		getHistoricalData();

		//market movers
		getMarketMovers();

		//market hours
		getMarketHours();

		//instruments
		getInstrumentsTest();
		getInstrumentByCUSIP();
	}

	private void runPlaceOrderTests() {
		//placeStockOrder();
		//placeSingleOptionOrder();
		//placeCOB();
		//oneOrderTriggersAnother();
		//oneTriggersAOneCancelsAnotherOrder();
	}

	private void oneTriggersAOneCancelsAnotherOrder() {
		String accountnumber = api.getRandomAccount().getValue();
		Order order = new Order(OrderType.LIMIT, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.TRIGGER);
		order.price = 180d;
		AccountEquity instrument = new AccountEquity("IBM");
		OrderLegCollection ol = new OrderLegCollection(Instruction.BUY, 3, instrument);
		order.addOrderLeg(ol);

		Order order2 = new Order(OrderType.LIMIT, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.SINGLE);
		order2.price = 231d;
		AccountEquity instrument2 = new AccountEquity("AAPL");
		OrderLegCollection ol2 = new OrderLegCollection(Instruction.BUY, 2, instrument2);
		order2.addOrderLeg(ol2);

		Order order3 = new Order(OrderType.STOP, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.SINGLE);
		order3.stopPrice = 120d;
		AccountEquity instrument3 = new AccountEquity("AMD");
		OrderLegCollection ol3 = new OrderLegCollection(Instruction.SELL, 2, instrument3);
		order3.addOrderLeg(ol3);

		Order triggeredcombo = new Order();
		triggeredcombo.orderStrategyType = OrderStrategyType.OCO;
		triggeredcombo.addChildOrderStrategy(order2);
		triggeredcombo.addChildOrderStrategy(order3);

		order.addChildOrderStrategy(triggeredcombo);
		try {
			api.submitOrder(order, accountnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void oneOrderTriggersAnother() {
		String accountnumber = api.getRandomAccount().getValue();
		Order order = new Order(OrderType.LIMIT, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.TRIGGER);
		order.price = 180d;
		AccountEquity instrument = new AccountEquity("IBM");
		OrderLegCollection ol = new OrderLegCollection(Instruction.BUY, 3, instrument);
		order.addOrderLeg(ol);
		Order triggeredorder = new Order(OrderType.LIMIT, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.SINGLE);
		triggeredorder.price = 240d;
		AccountEquity dependentorderinstrument = new AccountEquity("JPM");
		OrderLegCollection dependentorder = new OrderLegCollection(Instruction.BUY, 2, dependentorderinstrument);
		triggeredorder.addOrderLeg(dependentorder);
		order.addChildOrderStrategy(triggeredorder);
		try {
			api.submitOrder(order, accountnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void placeCOB() {
		List<String> spyatmoption = getSPYSymbols();
		int numlegs = 2;
		String[] randomsymbol = getRandomSymbol(spyatmoption, numlegs);
		String accountnumber = api.getRandomAccount().getValue();
		Order order = new Order(OrderType.NET_DEBIT, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.SINGLE);
		order.price = 0.08;
		for(int i = 0; i < numlegs; i++) {
			AccountOption instrument = new AccountOption(randomsymbol[i]);
			if(i % 2 == 0) {
				order.addOrderLeg(new OrderLegCollection(Instruction.BUY_TO_OPEN, 1, instrument));
			}
			else {
				order.addOrderLeg(new OrderLegCollection(Instruction.SELL_TO_OPEN, 1, instrument));
			}
		}
		try {
			api.submitOrder(order, accountnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void placeSingleOptionOrder() {
		List<String> spyatmoption = getSPYSymbols();
		String[] randomsymbol = getRandomSymbol(spyatmoption, 1);
		String accountnumber = api.getRandomAccount().getValue();
		Order order = new Order(OrderType.LIMIT, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.SINGLE);
		order.price = -500d;
		AccountOption instrument = new AccountOption(randomsymbol[0]);
		OrderLegCollection ol = new OrderLegCollection(Instruction.BUY_TO_OPEN, 1, instrument);
		order.addOrderLeg(ol);
		try {
			api.submitOrder(order, accountnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String[] getRandomSymbol(List<String> spyatmoption, int choosen) {
		String[] strs = new String[choosen];
		for(int i = 0; i < choosen; i++) {
			strs[i] = spyatmoption.get(i);
		}
		return strs;
	}

	private List<String> getSPYSymbols() {
		OptionsChainQuery query = new OptionsChainQuery("SPY");
		query.setRange(RangeType.NTM);
		query.setStrikeCount(2);
		query.setFromDate(LocalDate.now().plusDays(7));
		query.setToDate(LocalDate.now().plusDays(18));
		List<String> symbols = new ArrayList<>();
		try {
			OptionChain optionschain = api.getOptionsChains(query);
			getOptionSymbols(optionschain.callExpDateMap, symbols);
			getOptionSymbols(optionschain.putExpDateMap, symbols);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return symbols;
	}

	private void getOptionSymbols(Map<String, Map<String, List<OptionContract>>> optionmap, List<String> symbols) {
		for(Map<String, List<OptionContract>> cur1 : optionmap.values()) {
			for(List<OptionContract> contractmap : cur1.values()) {
				for(OptionContract contract : contractmap) {
					symbols.add(contract.symbol);
				}
			}
		}
	}

	//account tests
	private void placeStockOrder() {
		String accountnumber = api.getRandomAccount().getValue();
		Order order = new Order(OrderType.LIMIT, Session.NORMAL, Duration.GOOD_TILL_CANCEL, OrderStrategyType.SINGLE);
		order.price = 180d;
		AccountsInstrument instrument = new AccountEquity("IBM");
		OrderLegCollection ol = new OrderLegCollection(Instruction.BUY, 3, instrument);
		order.addOrderLeg(ol);
		try {
			api.submitOrder(order, accountnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//market data tests
	private void getOptionsChains() {
		try {
			OptionsChainQuery query = new OptionsChainQuery("AAPL");
			OptionChain optionschain = api.getOptionsChains(query);
			assertNotNull(optionschain);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getOptionsChainsNTM() {
		try {
			OptionsChainQuery query = new OptionsChainQuery("AAPL");
			query.setRange(RangeType.NTM);
			query.setStrikeCount(1);
			OptionChain optionschain = api.getOptionsChains(query);
			assertNotNull(optionschain);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getOptionsChainNTMByDateRange() {
		try {
			OptionsChainQuery query = new OptionsChainQuery("AAPL");
			query.setRange(RangeType.NTM);
			query.setStrikeCount(1);
			query.setFromDate(LocalDate.now());
			query.setToDate(LocalDate.now().plusDays(10));
			OptionChain optionschain = api.getOptionsChains(query);
			assertNotNull(optionschain);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getHistoricalData() {
		try {
			HistoricalDataQuery query = new HistoricalDataQuery("AAPL", PeriodType.year, 1, FrequencyType.daily, 1);
			query.setExtended(false);
			query.setIncludepreviousclose(true);
			CandleList histdata = api.getHistoricalData(query);
			assertNotNull(histdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getMarketMovers() {
		try {
			MarketMoversQuery query = new MarketMoversQuery(SymbolID.EQUITY_ALL);
			Screeners movers = api.getMarketMovers(query);
			assertNotNull(movers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getMarketHours() {
		try {
			//get next Wednesday
			LocalDate today = LocalDate.now();
	        LocalDate nextWednesday = today.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
			MarketHoursQuery query = new MarketHoursQuery(Market.equity, nextWednesday);
			MarketHours markethours = api.getMarketHours(query);
			assertNotNull(markethours);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getSingleQuote() {
		try {
			SingleQuoteQuery query = new SingleQuoteQuery("AAPL");
			QuoteResponse quote = api.getQuote(query);
			assertNotNull(quote);
			assert(quote.quotes.size() == 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getQuotes() {
		try {
			QuoteQuery query = new QuoteQuery("AAPL,AMD,MSFT");
			QuoteResponse quotes = api.getQuotes(query);
			assertNotNull(quotes);
			assert(!quotes.quotes.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getOptionExpirations() {
		try {
			ExpirationChain optionexpirations = api.getOptionExpirations("AMD");
			assertNotNull(optionexpirations);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getInstrumentsTest() {
		try {
			InstrumentResponse expirationdetails = api.getInstruments(new InstrumentSearchQuery("AAPL,AMD", Projection.Fundamental));
			assertNotNull(expirationdetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getInstrumentByCUSIP() {
		try {
			Instrument expirationdetails = api.getInstrumentByCUSIP("037833100");
			assertNotNull(expirationdetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

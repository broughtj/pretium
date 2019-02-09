package org.brough.pretium.Pricer;

import org.brough.pretium.MarketData;
import org.brough.pretium.Option;

public interface Pricer {
    double price(Option option, MarketData data);
}

package org.brough.pretium.PricingEngine;

import org.brough.pretium.MarketData;
import org.brough.pretium.Option;
import org.brough.pretium.Pricer.Pricer;

public interface PricingEngine {

    double calculate(Option theOption, Pricer pricer, MarketData theData);

}

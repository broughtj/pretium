package org.brough.pretium;

import org.brough.pretium.Pricer.Pricer;
import org.brough.pretium.PricingEngine.PricingEngine;

public class OptionFacade {

    private Option theOption;
    private PricingEngine theEngine;
    private MarketData theData;

    OptionFacade(Option theOption, PricingEngine theEngine, MarketData theData){
        this.theOption = theOption;
        this.theEngine = theEngine;
        this.theData = theData;
    }

    public double price(Pricer pricer){
        return theEngine.calculate(this.theOption, pricer, this.theData);
    }
}

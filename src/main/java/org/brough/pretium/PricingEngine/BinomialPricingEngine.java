package org.brough.pretium.PricingEngine;

import org.brough.pretium.MarketData;
import org.brough.pretium.Option;
import org.brough.pretium.Pricer.Pricer;

public class BinomialPricingEngine implements PricingEngine {

    int numSteps;
    Pricer pricer;

    public BinomialPricingEngine(int nsteps, Pricer pricer){
        this.pricer = pricer;
        this.numSteps = nsteps;
    }

    public double calculate(Option option, Pricer pricer, MarketData data){
        return pricer.price(option, data);
    }

    public void setPricingEngine(Pricer pricer) {
        this.pricer = pricer;
    }

    public long getNumSteps() {
        return this.numSteps;
    }

    public void setNumSteps(int nsteps) {
        this.numSteps = nsteps;
    }
}
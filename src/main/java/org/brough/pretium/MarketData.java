package org.brough.pretium;

public class MarketData {

    private double rate, spot, volatility, dividend;

    MarketData(double rate, double spot, double volatility, double dividend) {
        this.rate = rate;
        this.spot = spot;
        this.volatility = volatility;
        this.dividend = dividend;
    }

    MarketData(MarketData data){
        this.rate = data.getRate();
        this.spot = data.getSpot();
        this.volatility = data.getVolatility();
        this.dividend = data.getDividend();
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setSpot(double spot) {
        this.spot = spot;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }

    public void setDividend(double dividend) {
        this.dividend = dividend;
    }

    public double getRate() {
        return rate;
    }

    public double getSpot() {
        return spot;
    }

    public double getVolatility() {
        return volatility;
    }

    public double getDividend() {
        return dividend;
    }
}

package com.ca.logic;

public class CompoundInterestCalculator extends InterestCalculator {

    public CompoundInterestCalculator() {
    }

    @Override
    public Double calculate() {
        return ((super.principal * Math.pow(1 + (super.rate / 100), (float) (super.noOfDays / 365)) - super.principal));

    }

}

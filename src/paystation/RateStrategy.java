/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation;

/**
 *
 * @author johnn
 */
public abstract class RateStrategy {
    //pratik is testing this by adding 7 quarters
    //which will show 70 minutes
    //then he will choose progressie rate, and it should show 66-67 minutes
//+ moneyInserted: int
////+ timePurchased: int
////+ calculateTimeBought(int): int
    private int moneyInserted;
    private int timePurchased;

    //defualt constructor
    public RateStrategy(){
        moneyInserted = 0;
        timePurchased = 0;
    }


    public RateStrategy(int monIns){
        moneyInserted = monIns;
        timePurchased = calculateTimePurchased();
    }

    public void setMoneyInserted(int monIns){
        moneyInserted = monIns;
    }

    public int getMoneyInserted(){
        return moneyInserted;
    }

    /** calculateTimePurchased - calculates the time purchased for the given rate strategy
     *
     * @return the amount of time purchased as a double
     */
    protected abstract int calculateTimePurchased();

}

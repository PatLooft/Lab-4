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
public class ProgressiveStrategy extends RateStrategy {

    @Override
    public int getMoneyInserted() {
        return moneyInserted;
    }

    @Override
    public void setMoneyInserted(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    private int moneyInserted;
    private int timePurchased;

    //defualt constructor
    public ProgressiveStrategy(){
        moneyInserted = 0;
        timePurchased = 0;
    }

    public ProgressiveStrategy(int monIns){
        moneyInserted = monIns;
        timePurchased = calculateTimePurchased();
    }

//    Less than an Hour( 60 Min) or amount <150
//            -Time= ( amount *2)/5
//    Between 1st hour and 2nd hour or 350>amount >=150
//            -Time =(amount-150)*(3/10) +60
//    Greater than 2 hours so amount >= 350
//            -Time= (amount-350)/5 +120
    @Override
    protected int calculateTimePurchased() {
        //    Less than an Hour( 60 Min) or amount <150
//            -Time= ( amount *2)/5
        if(moneyInserted <= 150) {
            timePurchased = (moneyInserted * 2) / 5;
        }
        //    Between 1st hour and 2nd hour or 350>amount >=150
//            -Time =(amount-150)*(3/10) +60
        else if(moneyInserted > 150 && moneyInserted < 350){
            //double temp = (moneyInserted - 150) * (3.0 / 10.0);
            //high quality code right here
            timePurchased = (int)((double)(moneyInserted - 150) * (3.0 / 10.0) + 60);
        }
        //    Greater than 2 hours so amount >= 350
//            -Time= (amount-350)/5 +120
        else if(moneyInserted >= 350){
            timePurchased = (moneyInserted - 350) / 5 + 120;
        }
        return timePurchased;
    }

}

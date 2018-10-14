/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class AlternatingStrategy extends RateStrategy {

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
    private String dayOfTheWeek;

    //defualt constructor
    public AlternatingStrategy(){
        moneyInserted = 0;
        timePurchased = 0;
        dayOfTheWeek = "monday";
    }

    public AlternatingStrategy(int monIns, String day){
        moneyInserted = monIns;
        timePurchased = calculateTimePurchased();
        dayOfTheWeek.equals(day);
    }

    //    Less than an Hour( 60 Min) or amount <150
//            -Time= ( amount *2)/5
//    Between 1st hour and 2nd hour or 350>amount >=150
//            -Time =(amount-150)*(3/10) +60
//    Greater than 2 hours so amount >= 350
//            -Time= (amount-350)/5 +120
    @Override
    protected int calculateTimePurchased() {
        //gets day of the week
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if(day == Calendar.MONDAY || day == Calendar.TUESDAY || day == Calendar.WEDNESDAY ||
                day == Calendar.THURSDAY || day == Calendar.FRIDAY){
            linearRate();
        }
        else if(day == Calendar.SATURDAY || day == Calendar.SUNDAY){
            progressiveRate();
        }
        else{
            System.out.println("Please enter a valid day.");
        }
        return timePurchased;
    }

    protected int linearRate(){
        timePurchased = (moneyInserted * 2) / 5;
        return timePurchased;
    }

    protected int progressiveRate() {
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

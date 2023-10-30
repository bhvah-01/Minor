package model.expense;

import java.util.List;

import model.User;
import model.split.EqualSplit;
import model.split.Split;

public class EqualExpense extends Expense{
      public EqualExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof EqualSplit)) return false;
        }
        return true;
    }
}

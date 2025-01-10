package org.example.model;

public class Expense {
    private int expenseId;
    private String expenseDescription;
    private double expenseAmount;

    public Expense(int expenseId, String expenseDescription, double expenseAmount) {
        this.expenseId = expenseId;
        this.expenseDescription = expenseDescription;
        this.expenseAmount = expenseAmount;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}

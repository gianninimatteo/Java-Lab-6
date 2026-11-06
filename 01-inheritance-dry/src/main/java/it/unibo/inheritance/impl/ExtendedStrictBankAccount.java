package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.BankAccount;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

    private int transactions;

    public ExtendedStrictBankAccount(final int id, final double balance) {
        super(id, balance);
        this.transactions = 0;
    }


   private boolean isWithdrawAllowed(final double amount) {
        return getBalance() >= amount;
    }
    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + transactions * StrictBankAccount.TRANSACTION_FEE;
        if (checkUser(id) && isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() - feeAmount);
            transactions = 0;
        }
    }
}
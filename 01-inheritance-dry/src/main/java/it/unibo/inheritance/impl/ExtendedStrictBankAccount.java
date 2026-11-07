package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount { // Ereditarietà

    public ExtendedStrictBankAccount(final int id, final double balance) {
        super(id, balance);
    }

    //Controlla se il saldo è sufficiente per effettuare il prelievo (balance >= amount).
    //Da ridichiarare siccome è private nell'altra classe
   private boolean isWithdrawAllowed(final double amount) {
        return getBalance() >= amount;
    }

    // 'super.withdraw(id, amount)' richiama il metodo withdraw() della classe padre 'SimpleBankAccount'.
    // Non potevo richiamare direttamente il metodo come nella classe padre perchè 'transactionOp' è private.
    // La sintassi per richiamare un metodo della classe padre è sempre 'super.metodo(parametri)'.
    public void withdraw(final int id, final double amount) {
        if (isWithdrawAllowed(amount)) {
            super.withdraw(id, -amount);
        }
    }

    // 'transactions' è private quindi accedo al contatore tramite il metodo public 'getTransactionsCount()' della classe SimpleBankAccount.
    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * StrictBankAccount.TRANSACTION_FEE;
        if (checkUser(id) && isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() - feeAmount);
            resetTransactions(); //Posso richiamare direttamente il metodo perchè è 'protected', senza doverlo ridichiarare.
        }
    }
}
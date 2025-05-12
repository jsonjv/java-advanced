package exceptions;

public class Account {
    private float balance;

    public void deposit(float value) {
        // Defensive programming
        if (value <= 0)
            // Throwing exceptions
            throw new IllegalArgumentException();
    }

    public void withdraw(float value) throws AccountException {
        if (value > this.balance) {
//            var fundsException = new InsufficientFundsException();
//            var accountException = new AccountException();
//
//            accountException.initCause(fundsException);
//            throw accountException;

            throw new AccountException(new InsufficientFundsException());
        }
    }
}

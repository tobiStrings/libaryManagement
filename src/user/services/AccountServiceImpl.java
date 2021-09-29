package user.services;

import user.entities.Account;
import user.services.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public double calculateFine(Account account) {
        for(int i = 0; i< account.getNumberOfLostBooks(); i++){
            account.setFineAmount(50.0);
        }
        return account.getFineAmount();
    }
}

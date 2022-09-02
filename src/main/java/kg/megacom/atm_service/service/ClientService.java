package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.Account;
import kg.megacom.atm_service.models.enums.Currency;

public interface ClientService {
    Account clientRegistration(String name, double limit, Currency currency);
}

package tech.jhipster.sample.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.BankAccount;
import tech.jhipster.sample.repository.BankAccountRepository;
import tech.jhipster.sample.service.BankAccountService;

/**
 * Service Implementation for managing {@link BankAccount}.
 */
@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {

    private final Logger log = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Mono<BankAccount> save(BankAccount bankAccount) {
        log.debug("Request to save BankAccount : {}", bankAccount);
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public Mono<BankAccount> partialUpdate(BankAccount bankAccount) {
        log.debug("Request to partially update BankAccount : {}", bankAccount);

        return bankAccountRepository
            .findById(bankAccount.getId())
            .map(existingBankAccount -> {
                if (bankAccount.getName() != null) {
                    existingBankAccount.setName(bankAccount.getName());
                }
                if (bankAccount.getGuid() != null) {
                    existingBankAccount.setGuid(bankAccount.getGuid());
                }
                if (bankAccount.getBankNumber() != null) {
                    existingBankAccount.setBankNumber(bankAccount.getBankNumber());
                }
                if (bankAccount.getAgencyNumber() != null) {
                    existingBankAccount.setAgencyNumber(bankAccount.getAgencyNumber());
                }
                if (bankAccount.getLastOperationDuration() != null) {
                    existingBankAccount.setLastOperationDuration(bankAccount.getLastOperationDuration());
                }
                if (bankAccount.getMeanOperationDuration() != null) {
                    existingBankAccount.setMeanOperationDuration(bankAccount.getMeanOperationDuration());
                }
                if (bankAccount.getMeanQueueDuration() != null) {
                    existingBankAccount.setMeanQueueDuration(bankAccount.getMeanQueueDuration());
                }
                if (bankAccount.getBalance() != null) {
                    existingBankAccount.setBalance(bankAccount.getBalance());
                }
                if (bankAccount.getOpeningDay() != null) {
                    existingBankAccount.setOpeningDay(bankAccount.getOpeningDay());
                }
                if (bankAccount.getLastOperationDate() != null) {
                    existingBankAccount.setLastOperationDate(bankAccount.getLastOperationDate());
                }
                if (bankAccount.getActive() != null) {
                    existingBankAccount.setActive(bankAccount.getActive());
                }
                if (bankAccount.getAccountType() != null) {
                    existingBankAccount.setAccountType(bankAccount.getAccountType());
                }
                if (bankAccount.getAttachment() != null) {
                    existingBankAccount.setAttachment(bankAccount.getAttachment());
                }
                if (bankAccount.getAttachmentContentType() != null) {
                    existingBankAccount.setAttachmentContentType(bankAccount.getAttachmentContentType());
                }
                if (bankAccount.getDescription() != null) {
                    existingBankAccount.setDescription(bankAccount.getDescription());
                }

                return existingBankAccount;
            })
            .flatMap(bankAccountRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<BankAccount> findAll() {
        log.debug("Request to get all BankAccounts");
        return bankAccountRepository.findAll();
    }

    public Mono<Long> countAll() {
        return bankAccountRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<BankAccount> findOne(Long id) {
        log.debug("Request to get BankAccount : {}", id);
        return bankAccountRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete BankAccount : {}", id);
        return bankAccountRepository.deleteById(id);
    }
}

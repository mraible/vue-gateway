package tech.jhipster.sample.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import tech.jhipster.sample.domain.enumeration.BankAccountType;

/**
 * A BankAccount.
 */
@Table("bank_account")
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @NotNull(message = "must not be null")
    @Column("name")
    private String name;

    @Column("guid")
    private UUID guid;

    @Column("bank_number")
    private Integer bankNumber;

    @Column("agency_number")
    private Long agencyNumber;

    @Column("last_operation_duration")
    private Float lastOperationDuration;

    @Column("mean_operation_duration")
    private Double meanOperationDuration;

    @Column("mean_queue_duration")
    private Duration meanQueueDuration;

    @NotNull(message = "must not be null")
    @Column("balance")
    private BigDecimal balance;

    @Column("opening_day")
    private LocalDate openingDay;

    @Column("last_operation_date")
    private Instant lastOperationDate;

    @Column("active")
    private Boolean active;

    @Column("account_type")
    private BankAccountType accountType;

    @Column("attachment")
    private byte[] attachment;

    @Column("attachment_content_type")
    private String attachmentContentType;

    @Column("description")
    private String description;

    @Transient
    private User user;

    @Transient
    @JsonIgnoreProperties(value = { "bankAccount", "labels" }, allowSetters = true)
    private Set<Operation> operations = new HashSet<>();

    @Column("user_id")
    private Long userId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public BankAccount id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public BankAccount name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getGuid() {
        return this.guid;
    }

    public BankAccount guid(UUID guid) {
        this.setGuid(guid);
        return this;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public Integer getBankNumber() {
        return this.bankNumber;
    }

    public BankAccount bankNumber(Integer bankNumber) {
        this.setBankNumber(bankNumber);
        return this;
    }

    public void setBankNumber(Integer bankNumber) {
        this.bankNumber = bankNumber;
    }

    public Long getAgencyNumber() {
        return this.agencyNumber;
    }

    public BankAccount agencyNumber(Long agencyNumber) {
        this.setAgencyNumber(agencyNumber);
        return this;
    }

    public void setAgencyNumber(Long agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public Float getLastOperationDuration() {
        return this.lastOperationDuration;
    }

    public BankAccount lastOperationDuration(Float lastOperationDuration) {
        this.setLastOperationDuration(lastOperationDuration);
        return this;
    }

    public void setLastOperationDuration(Float lastOperationDuration) {
        this.lastOperationDuration = lastOperationDuration;
    }

    public Double getMeanOperationDuration() {
        return this.meanOperationDuration;
    }

    public BankAccount meanOperationDuration(Double meanOperationDuration) {
        this.setMeanOperationDuration(meanOperationDuration);
        return this;
    }

    public void setMeanOperationDuration(Double meanOperationDuration) {
        this.meanOperationDuration = meanOperationDuration;
    }

    public Duration getMeanQueueDuration() {
        return this.meanQueueDuration;
    }

    public BankAccount meanQueueDuration(Duration meanQueueDuration) {
        this.setMeanQueueDuration(meanQueueDuration);
        return this;
    }

    public void setMeanQueueDuration(Duration meanQueueDuration) {
        this.meanQueueDuration = meanQueueDuration;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public BankAccount balance(BigDecimal balance) {
        this.setBalance(balance);
        return this;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance != null ? balance.stripTrailingZeros() : null;
    }

    public LocalDate getOpeningDay() {
        return this.openingDay;
    }

    public BankAccount openingDay(LocalDate openingDay) {
        this.setOpeningDay(openingDay);
        return this;
    }

    public void setOpeningDay(LocalDate openingDay) {
        this.openingDay = openingDay;
    }

    public Instant getLastOperationDate() {
        return this.lastOperationDate;
    }

    public BankAccount lastOperationDate(Instant lastOperationDate) {
        this.setLastOperationDate(lastOperationDate);
        return this;
    }

    public void setLastOperationDate(Instant lastOperationDate) {
        this.lastOperationDate = lastOperationDate;
    }

    public Boolean getActive() {
        return this.active;
    }

    public BankAccount active(Boolean active) {
        this.setActive(active);
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public BankAccountType getAccountType() {
        return this.accountType;
    }

    public BankAccount accountType(BankAccountType accountType) {
        this.setAccountType(accountType);
        return this;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    public byte[] getAttachment() {
        return this.attachment;
    }

    public BankAccount attachment(byte[] attachment) {
        this.setAttachment(attachment);
        return this;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public String getAttachmentContentType() {
        return this.attachmentContentType;
    }

    public BankAccount attachmentContentType(String attachmentContentType) {
        this.attachmentContentType = attachmentContentType;
        return this;
    }

    public void setAttachmentContentType(String attachmentContentType) {
        this.attachmentContentType = attachmentContentType;
    }

    public String getDescription() {
        return this.description;
    }

    public BankAccount description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
        this.userId = user != null ? user.getId() : null;
    }

    public BankAccount user(User user) {
        this.setUser(user);
        return this;
    }

    public Set<Operation> getOperations() {
        return this.operations;
    }

    public void setOperations(Set<Operation> operations) {
        if (this.operations != null) {
            this.operations.forEach(i -> i.setBankAccount(null));
        }
        if (operations != null) {
            operations.forEach(i -> i.setBankAccount(this));
        }
        this.operations = operations;
    }

    public BankAccount operations(Set<Operation> operations) {
        this.setOperations(operations);
        return this;
    }

    public BankAccount addOperation(Operation operation) {
        this.operations.add(operation);
        operation.setBankAccount(this);
        return this;
    }

    public BankAccount removeOperation(Operation operation) {
        this.operations.remove(operation);
        operation.setBankAccount(null);
        return this;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long user) {
        this.userId = user;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankAccount)) {
            return false;
        }
        return id != null && id.equals(((BankAccount) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BankAccount{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", guid='" + getGuid() + "'" +
            ", bankNumber=" + getBankNumber() +
            ", agencyNumber=" + getAgencyNumber() +
            ", lastOperationDuration=" + getLastOperationDuration() +
            ", meanOperationDuration=" + getMeanOperationDuration() +
            ", meanQueueDuration='" + getMeanQueueDuration() + "'" +
            ", balance=" + getBalance() +
            ", openingDay='" + getOpeningDay() + "'" +
            ", lastOperationDate='" + getLastOperationDate() + "'" +
            ", active='" + getActive() + "'" +
            ", accountType='" + getAccountType() + "'" +
            ", attachment='" + getAttachment() + "'" +
            ", attachmentContentType='" + getAttachmentContentType() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}

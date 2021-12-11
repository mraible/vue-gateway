package tech.jhipster.sample.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import tech.jhipster.sample.domain.enumeration.MyEnumA;
import tech.jhipster.sample.domain.enumeration.MyEnumB;
import tech.jhipster.sample.domain.enumeration.MyEnumC;

/**
 * A FieldTestEnumWithValue.
 */
@Table("entity_with_enums")
public class FieldTestEnumWithValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("my_field_a")
    private MyEnumA myFieldA;

    @Column("my_field_b")
    private MyEnumB myFieldB;

    @Column("my_field_c")
    private MyEnumC myFieldC;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FieldTestEnumWithValue id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyEnumA getMyFieldA() {
        return this.myFieldA;
    }

    public FieldTestEnumWithValue myFieldA(MyEnumA myFieldA) {
        this.setMyFieldA(myFieldA);
        return this;
    }

    public void setMyFieldA(MyEnumA myFieldA) {
        this.myFieldA = myFieldA;
    }

    public MyEnumB getMyFieldB() {
        return this.myFieldB;
    }

    public FieldTestEnumWithValue myFieldB(MyEnumB myFieldB) {
        this.setMyFieldB(myFieldB);
        return this;
    }

    public void setMyFieldB(MyEnumB myFieldB) {
        this.myFieldB = myFieldB;
    }

    public MyEnumC getMyFieldC() {
        return this.myFieldC;
    }

    public FieldTestEnumWithValue myFieldC(MyEnumC myFieldC) {
        this.setMyFieldC(myFieldC);
        return this;
    }

    public void setMyFieldC(MyEnumC myFieldC) {
        this.myFieldC = myFieldC;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldTestEnumWithValue)) {
            return false;
        }
        return id != null && id.equals(((FieldTestEnumWithValue) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FieldTestEnumWithValue{" +
            "id=" + getId() +
            ", myFieldA='" + getMyFieldA() + "'" +
            ", myFieldB='" + getMyFieldB() + "'" +
            ", myFieldC='" + getMyFieldC() + "'" +
            "}";
    }
}

package tech.jhipster.sample.domain.enumeration;

/**
 * The MyEnumB enumeration.
 */
public enum MyEnumB {
    AAA("aaa_aaa"),
    BBB;

    private String value;

    MyEnumB() {}

    MyEnumB(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package tech.jhipster.sample.domain.enumeration;

/**
 * The MyEnumC enumeration.
 */
public enum MyEnumC {
    AAA("aaa_aaa"),
    BBB("b and b");

    private final String value;

    MyEnumC(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

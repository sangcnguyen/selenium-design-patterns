package builder;

public class BillingInfor {
    // require params
    private final String name;
    private final String address;
    private final String city;
    // optional params
    private final String state;
    private final String zipCode;
    private final String cardType;
    private final String cardNumber;
    private final String cardMonth;
    private final String cardYear;
    private final String nameOnCard;

    private BillingInfor(BillingInformationBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.cardType = builder.cardType;
        this.cardNumber = builder.cardNumber;
        this.cardMonth = builder.cardMonth;
        this.cardYear = builder.cardYear;
        this.nameOnCard = builder.nameOnCard;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardMonth() {
        return cardMonth;
    }

    public String getCardYear() {
        return cardYear;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public static class BillingInformationBuilder {
        private final String name;
        private final String address;
        private final String city;
        private String state;
        private String zipCode;
        private String cardType;
        private String cardNumber;
        private String cardMonth;
        private String cardYear;
        private String nameOnCard;

        public BillingInformationBuilder(String name, String address, String city) {
            this.name = name;
            this.address = address;
            this.city = city;
        }

        public BillingInformationBuilder state(String state) {
            this.state = state;
            return this;
        }

        public BillingInformationBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public BillingInformationBuilder cardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        public BillingInformationBuilder cardNumber(String creditCardNumber) {
            this.cardNumber = creditCardNumber;
            return this;
        }

        public BillingInformationBuilder cardMonth(String cardMonth) {
            this.cardMonth = cardMonth;
            return this;
        }

        public BillingInformationBuilder cardYear(String cardYear) {
            this.cardYear = cardYear;
            return this;
        }

        public BillingInformationBuilder nameOnCard(String nameOnCard) {
            this.nameOnCard = nameOnCard;
            return this;
        }

        public BillingInfor build() {
            validateRequireField();
            return new BillingInfor(this);
        }

        private void validateRequireField() {
            if (name.length() == 0 || address.length() == 0 || city.length() == 0) {
                throw new IllegalArgumentException("Can't be empty string");
            }
        }
    }
}

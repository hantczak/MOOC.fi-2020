
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public Money plus(Money addition) {
        Money newMoney = new Money(this.euros + addition.euros, this.cents + addition.cents);
        return newMoney;
    }

    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        }
        if (this.euros == compared.euros) {
            if (this.cents < compared.cents) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Money minus(Money decreaser) {
        if (decreaser.euros > this.euros) {
            Money lessThanZero = new Money(0, 0);
            return lessThanZero;
        }

        if (decreaser.euros == this.euros) {
            if (decreaser.cents > this.cents) {
                Money lessThanZero = new Money(0, 0);
                return lessThanZero;
            }
        }

        if (decreaser.cents > this.cents) {
            int euros = this.euros - decreaser.euros - 1;
            int cents = (this.cents - decreaser.cents) + 100;
            Money newMoney = new Money(euros,cents);
            return newMoney;
        }
        Money newMoney = new Money(this.euros - decreaser.euros, this.cents - decreaser.cents);
        return newMoney;
    }


    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}


interface PaymentProcessor { void pay(double amt); }
class LegacyBank {
    public void makePayment(double a) {
        System.out.println("Paid via bank: " + a);
    }
}
class BankAdapter implements PaymentProcessor {
    private LegacyBank bank = new LegacyBank();
    public void pay(double amt) {
        bank.makePayment(amt);
    }
}
class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new BankAdapter();
        processor.pay(500);
    }
}
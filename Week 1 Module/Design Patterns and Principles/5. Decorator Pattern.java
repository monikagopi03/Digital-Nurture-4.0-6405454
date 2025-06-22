
interface Notifier { void send(String msg); }
class EmailNotifier implements Notifier {
    public void send(String msg) { System.out.println("Email: " + msg); }
}
class NotifierDecorator implements Notifier {
    protected Notifier wrap;
    public NotifierDecorator(Notifier n) { wrap = n; }
    public void send(String msg) { wrap.send(msg); }
}
class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier n) { super(n); }
    public void send(String msg) {
        super.send(msg);
        System.out.println("SMS: " + msg);
    }
}
class DecoratorTest {
    public static void main(String[] args) {
        Notifier n = new SMSDecorator(new EmailNotifier());
        n.send("Hello");
    }
}
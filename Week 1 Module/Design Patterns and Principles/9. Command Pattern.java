
interface Command { void execute(); }
class Light {
    public void on() { System.out.println("Light ON"); }
    public void off() { System.out.println("Light OFF"); }
}
class LightOnCmd implements Command {
    private Light l;
    public LightOnCmd(Light l) { this.l = l; }
    public void execute() { l.on(); }
}
class Remote {
    private Command c;
    public void set(Command c) { this.c = c; }
    public void press() { c.execute(); }
}
class CommandTest {
    public static void main(String[] args) {
        Light l = new Light();
        Remote r = new Remote();
        r.set(new LightOnCmd(l));
        r.press();
    }
}

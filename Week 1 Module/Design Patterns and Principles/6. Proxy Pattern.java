
interface Image { void display(); }
class RealImage implements Image {
    private String file;
    public RealImage(String f) { file = f; load(); }
    private void load() { System.out.println("Loading: " + file); }
    public void display() { System.out.println("Showing: " + file); }
}
class ProxyImage implements Image {
    private String file;
    private RealImage real;
    public ProxyImage(String f) { file = f; }
    public void display() {
        if (real == null) real = new RealImage(file);
        real.display();
    }
}
class ProxyTest {
    public static void main(String[] args) {
        Image img = new ProxyImage("photo.jpg");
        img.display();
        img.display();
    }
}

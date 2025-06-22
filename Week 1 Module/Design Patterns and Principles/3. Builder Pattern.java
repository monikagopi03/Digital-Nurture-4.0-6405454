
class Computer {
    private String cpu;
    private int ram;
    private int storage;
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        public Builder cpu(String c) { cpu = c; return this; }
        public Builder ram(int r) { ram = r; return this; }
        public Builder storage(int s) { storage = s; return this; }
        public Computer build() { return new Computer(this); }
    }
    private Computer(Builder b) {
        cpu = b.cpu; ram = b.ram; storage = b.storage;
    }
    public String toString() {
        return "CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage;
    }
}
class BuilderTest {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder().cpu("i5").ram(8).storage(256).build();
        System.out.println(pc);
    }
}
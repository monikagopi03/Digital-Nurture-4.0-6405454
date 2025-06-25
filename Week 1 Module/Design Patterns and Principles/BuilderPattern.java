class Computer {
    private final String cpu;
    private final int ram;
    private final int storage;
    private final boolean graphicsCard;
    private final String os;

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private boolean graphicsCard;
        private String os;

        public Builder cpu(String c) { cpu = c; return this; }
        public Builder ram(int r) { ram = r; return this; }
        public Builder storage(int s) { storage = s; return this; }
        public Builder graphicsCard(boolean g) { graphicsCard = g; return this; }
        public Builder os(String o) { os = o; return this; }
        public Computer build() { return new Computer(this); }
    }

    private Computer(Builder b) {
        cpu = b.cpu;
        ram = b.ram;
        storage = b.storage;
        graphicsCard = b.graphicsCard;
        os = b.os;
    }

    public String toString() {
        return "CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage +
               ", GraphicsCard=" + graphicsCard + ", OS=" + os;
    }
}

class BuilderTest {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder()
                        .cpu("i7")
                        .ram(16)
                        .storage(512)
                        .graphicsCard(true)
                        .os("Windows 11")
                        .build();
        System.out.println(pc);
    }
}

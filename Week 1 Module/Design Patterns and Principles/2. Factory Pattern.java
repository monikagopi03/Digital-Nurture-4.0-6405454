
interface Document { void open(); }
class WordDoc implements Document {
    public void open() { System.out.println("Word Document Opened"); }
}
class PdfDoc implements Document {
    public void open() { System.out.println("PDF Document Opened"); }
}
class DocumentFactory {
    public static Document create(String type) {
        return switch(type.toLowerCase()) {
            case "word" -> new WordDoc();
            case "pdf" -> new PdfDoc();
            default -> null;
        };
    }
}
class FactoryTest {
    public static void main(String[] args) {
        Document doc = DocumentFactory.create("pdf");
        doc.open();
    }
}
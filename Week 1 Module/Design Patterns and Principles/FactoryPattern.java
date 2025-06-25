interface Document {
    void open();
}

class WordDoc implements Document {
    public void open() {
        System.out.println("Word Document Opened");
    }
}

class PdfDoc implements Document {
    public void open() {
        System.out.println("PDF Document Opened");
    }
}

class ExcelDoc implements Document {
    public void open() {
        System.out.println("Excel Document Opened");
    }
}

class DocumentFactory {
    public static Document create(String type) {
        return switch (type.toLowerCase()) {
            case "word" -> new WordDoc();
            case "pdf" -> new PdfDoc();
            case "excel" -> new ExcelDoc();
            default -> throw new IllegalArgumentException("Unknown document type: " + type);
        };
    }
}

class FactoryPattern {
    public static void main(String[] args) {
        Document doc1 = DocumentFactory.create("pdf");
        doc1.open();
        Document doc2 = DocumentFactory.create("word");
        doc2.open();
        Document doc3 = DocumentFactory.create("excel");
        doc3.open();
    }
}

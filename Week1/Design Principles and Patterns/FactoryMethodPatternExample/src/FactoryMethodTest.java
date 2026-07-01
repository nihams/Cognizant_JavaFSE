public class FactoryMethodTest {

    public static void main(String[] args) {

        System.out.println("=== Factory Method Pattern Test ===");

        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        wordFactory.processDocument();
        pdfFactory.processDocument();
        excelFactory.processDocument();

        System.out.println("\n--- Direct document creation via factory ---");

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        System.out.println("Created: " + word.getType());
        System.out.println("Created: " + pdf.getType());
        System.out.println("Created: " + excel.getType());

        System.out.println("\nConclusion: Each factory produces its own document type.");
    }
}

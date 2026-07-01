public abstract class DocumentFactory {

    public abstract Document createDocument();

    public void processDocument() {
        Document doc = createDocument();
        System.out.println("\n--- Processing: " + doc.getType() + " ---");
        doc.open();
        doc.save();
        doc.close();
    }
}

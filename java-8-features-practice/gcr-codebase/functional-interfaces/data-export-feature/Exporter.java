interface Exporter{

    void export();
    default void exportToJson(){
        System.out.println("Exporting data to JSON");
    }
}
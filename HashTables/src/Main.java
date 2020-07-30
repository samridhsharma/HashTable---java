public class Main {

    public static void main(String[] args) {

        System.out.println("*********** WELCOME **************");

        HashTable table = new HashTable(50);


        //Insert values :
        table.insert("a");
        table.insert("b");
        table.insert("c");
        table.insert("d");
        table.insert("e");
        table.insert("f");
        table.insert("g");
        table.insert("h");
        table.insert("a");


        //display HashTable :
        table.displayTable();

        //find Value :
        System.out.println(table.find("a") + " position");
    }
}


    interface PrinterInterface{
        void print();
    }
    class Printer implements PrinterInterface{
        String message;
        Printer(String message){
            this.message = message;
        }
        public void print() {
            System.out.print(message);
        }
    }
    abstract class Decorator implements PrinterInterface{
        PrinterInterface printerInterface;
        Decorator(PrinterInterface printerInterface){
            this.printerInterface = printerInterface;
        }
        public void print(){
            printerInterface.print();
        }
    }
     class QuotesDecorator extends Decorator{
        QuotesDecorator(PrinterInterface printerInterface) {
            super(printerInterface);
        }
        public void print(){
            System.out.print("\"");
            super.print();
            System.out.println("\"");
        }
    }
    public class DecoratorPattern {

    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new Printer("Hello"));
        printer.print();
    }
}

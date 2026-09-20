// Class & Object Differences

// Class is being defined here (blueprint for phone)
public static class Phone {
    public String number;

    public void call() {
        System.out.println("Calling "+ number + "...");
        System.out.println("Ring...\nRing...\nRing...");
    }
}
void main() {
    // Create an instance (object) of the Phone class
    Phone iPhone = new Phone();
    iPhone.number = "+1 212-289-9265";
    iPhone.call();
}

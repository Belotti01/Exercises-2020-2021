public class main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Test", 100.0315);
        BankAccount acc2 = new BankAccount("Test2", 55.05);
        double testTransfer, previousBalance1;

        System.out.println("\n[ Created " + acc1.getOwner() + " & " + acc2.getOwner() + ": ]");
        System.out.println("- " + acc1.getOwner() + " " + acc1.getBalance());
        System.out.println("- " + acc2.getOwner() + " " + acc2.getBalance());

        //Test by BankAccount (object)
        testTransfer = 150.05;
        previousBalance1 = acc1.getBalance();
        acc1.transfer(acc2, testTransfer);
        System.out.println("\n[ " + (acc1.getBalance() != previousBalance1 ? "Successfully transferred " : "Failed to transfer ") + " (BankAccount, double) " + testTransfer + "$ from Test to Test2: ]");
        System.out.println("- " + acc1.getOwner() + " " + acc1.getBalance());
        System.out.println("- " + acc2.getOwner() + " " + acc2.getBalance());
        
        //Test by owner name (String)
        testTransfer = 8335.90;
        previousBalance1 = acc1.getBalance();
        acc2.transfer("Test", testTransfer);
        System.out.println("\n[ " + (acc1.getBalance() != previousBalance1 ? "Successfully transferred " : "Failed to transfer ") + " (String, double) " + testTransfer + "$ from Test to Test2: ]");
        System.out.println("- " + acc1.getOwner() + " " + acc1.getBalance());
        System.out.println("- " + acc2.getOwner() + " " + acc2.getBalance());
    }
} 
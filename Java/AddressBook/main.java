class main {
    public static void main(String[] args) {

        String[] names = {"a", "b", "c"};
        String[] surnames = {"d", "e", "f"};
        String[] numbers = {"33 0123456789", "1234098765", "1234 1234567890"};

        AddressBook book = new AddressBook();

        for(int i = 0; i < names.length; i++) {
            Address address;
            try{
                address = new Address(names[i], surnames[i], numbers[i]);
                book.add(address);
                System.out.println((i+1) + "> " + book.findByName(names[i]).stringify());
            }catch(Exception e) {
                System.out.println((i+1) + "> EXCEPTION: Address \"" + names[i] + " " + surnames[i] + " - " + numbers[i] + "\" threw exception:\n\t" + e.getMessage());
            }
        }
    }
}
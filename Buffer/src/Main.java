public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.addBlock(new Transaction("Sapna", "Shreya", 10.0));
        blockchain.addBlock(new Transaction("Shreya", "Vaishnavi", 5.0));
        blockchain.addBlock(new Transaction("Vaishnavi", "Sapna", 3.0));
        System.out.println(blockchain);
    }
}

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private final int index;
    private final long timestamp;
    private final Transaction transaction;
    private final String hash;
    private final String previousHash;

    public Block(int index, long timestamp, Transaction transaction, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String calculateHash() {
        String dataToHash = index + timestamp + transaction.toString() + previousHash;
        MessageDigest digest = null;
        byte[] bytes = null;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();

        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }

        return builder.toString();
    }

}
import java.util.ArrayList;

public class Blockchain {
    private final ArrayList<Block> chain;

    public Blockchain() {
        chain = new ArrayList<Block>();
        chain.add(createGenesisBlock());
    }

    public Block createGenesisBlock() {
        return new Block(0, System.currentTimeMillis(), new Transaction("Genesis", "Genesis", 0.0), "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Transaction transaction) {
        Block newBlock = new Block(getLatestBlock().getIndex() + 1, System.currentTimeMillis(), transaction, getLatestBlock().getHash());
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                return false;
            }
        }

        return true;
    }
}
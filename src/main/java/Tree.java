import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.logging.Logger;

public class Tree implements TreeInterface {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    private TreeTrunk treeTrunk;

    public void setTreeTrunk(TreeTrunk treeTrunk) {
        this.treeTrunk = treeTrunk;
    }

    public Tree(TreeTrunk treeTrunk) {
        this.treeTrunk = treeTrunk;
        LOGGER.info("Created tree has: " + this.treeTrunk.getBranchList().toArray().length + " branch/es");
    }

    public Tree() {
        this.treeTrunk = new TreeTrunk();
    }

    public TreeTrunk getTreeTrunk() {
        return treeTrunk;
    }

    private Integer generateRandomNumber(Integer low, Integer high) {
        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        return result;
    }

    @Override
    public void grow() {
        Integer result = generateRandomNumber(1, 7);
        List<Branch> newBranches = new ArrayList<>();
        for (int i = 0; i <= result - 1; i++) {
            Branch branch = new Branch();
            newBranches.add(branch);
        }
        System.out.println(this.treeTrunk.getBranchList());
        this.treeTrunk.getBranchList().addAll(newBranches);


        System.out.println("Number of branches after growth : " + this.treeTrunk.getBranchList().toArray().length);
        System.out.println(this.treeTrunk.getBranchList());
    }

    @Override
    public void growLeaves() {
        Integer numberOfBranches = treeTrunk.getBranchList().size();
        for (int i = 0; i < numberOfBranches - 1; i++) {
            Integer result = generateRandomNumber(10, 20);
            List<Leaf> newLeaves = new ArrayList<>();
            for (int l = 1; l <= result +1; l++) {
                Leaf leaf = new Leaf();
                newLeaves.add(leaf);
            }
            this.treeTrunk.getBranchList().get(i).getLeafList().addAll(newLeaves);

        }
        Map<Branch, Integer> map = new HashMap<Branch, Integer>() {{
            for (int i = 0; i < treeTrunk.getBranchList().size(); i++) {
                put(treeTrunk.getBranchList().get(i), treeTrunk.getBranchList().get(i).getLeafList().size());
            }
        }};
        System.out.println("Hashmap below presents branches with number of their leaves after regrowth: ");
        System.out.println(map);
        this.treeTrunk.getBranchList();


    }

    @Override
    public Tree generateParameterTree(LeafType leafType, Integer numberOfBranches, Integer numberOfLeavesInEveryBranch) {
        List<Branch> branchList = new ArrayList<>();
        for(int i=0; i<numberOfBranches;i++ ){
            Branch branch = new Branch();
            branchList.add(branch);
        }
        this.treeTrunk.setBranchList(branchList);
        List<Branch> branchList1 = this.treeTrunk.getBranchList();
        for(Branch b : branchList1 ){
            List<Leaf> leafList = IntStream.range(0,numberOfLeavesInEveryBranch).mapToObj(k -> new Leaf(leafType)).collect(Collectors.toList());
            b.setLeafList(leafList);
        }
        return this;

    }

    @Override
    public int numberOfBranches() {
        return this.treeTrunk.getBranchList().size();
    }


}

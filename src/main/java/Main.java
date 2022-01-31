import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //drzewo liściaste
        Tree leafTree = generateRandomLeafTree();
        leafTree.grow();
        leafTree.growLeaves();
    }
    public static Tree generateRandomLeafTree() {
        Integer numberOfBranches = generateRandomNumber(1,10);
        List<Branch> allBranches = new ArrayList<>();
        for(int i=0; i< numberOfBranches-1; i++) {
            List<Leaf> allLeavesForOneBranch = IntStream.range(0, generateRandomNumber(10, 20)).mapToObj(k -> new Leaf(LeafType.LEAF)).collect(Collectors.toList());
            Branch branch = new Branch(allLeavesForOneBranch);
            allBranches.add(branch);

        }
        TreeTrunk treeTrunk = new TreeTrunk(allBranches);
        Tree tree = new Tree(treeTrunk);
        return tree;
    }
    public static void generateRandomConiferTree() {

    }

    public static Integer generateRandomNumber(Integer low, Integer high) {
        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        return result;
    }
}

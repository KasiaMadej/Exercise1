public interface TreeInterface {
    public void grow();
    public void growLeaves();
    public Tree generateParameterTree(LeafType leafType,Integer numberOfBranches, Integer numberOfLeaves);
    public int numberOfBranches();
    //dropLeaves

}

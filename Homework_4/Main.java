public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setRoot(tree.treeBuild(10));
        System.out.println(tree.toString());
    }
}

class Solution {
    public int countHighestScoreNodes(int[] parents) {
        //--build tree start--
        Node[] arr = new Node[parents.length];
        for(int i = 0;i<parents.length;i++)
            arr[i] = new Node();
        
        for(int i = 1;i<parents.length;i++){
            arr[i].parent = arr[parents[i]];
            arr[i].id = i;
            if(arr[parents[i]].left==null){
                arr[parents[i]].left = arr[i];
            }else
                arr[parents[i]].right = arr[i];
        }
        // --build tree complete---
        
        countLeftAndRightScoreNodes(arr[0]);// build node's left and right count maps

        for(Node node: arr){//calculate product of all subtrees for given node
            long parentSide = 1, rightSide = rcMap.getOrDefault(node.id,0), leftSide = lcMap.getOrDefault(node.id,0);
            parentSide = (rcMap.getOrDefault(0,0)+lcMap.getOrDefault(0,0)+1) - (rightSide+leftSide+1); // root's left count + root's right count - (current node and below count)
            long product = Math.max(parentSide,1)*Math.max(rightSide,1)*Math.max(leftSide,1);
            tm.put(product,tm.getOrDefault(product, 0)+1);
        }
        return tm.get(tm.lastKey());
    }
    
    TreeMap<Long, Integer> tm = new TreeMap<>();
    Map<Integer,Integer> lcMap = new HashMap<>();//left count
    Map<Integer,Integer> rcMap = new HashMap<>();

    void countLeftAndRightScoreNodes(Node root){//post order traversal to build left and right node counts
        if(root == null)
            return;
        countLeftAndRightScoreNodes(root.left);
        countLeftAndRightScoreNodes(root.right);

        int currentCount = (root.left!=null?lcMap.getOrDefault(root.id,0):0)+(root.right!=null?rcMap.getOrDefault(root.id,0):0)+1;
        if(root.parent==null)
            return;
        if(root==root.parent.left){
            lcMap.put(root.parent.id,currentCount);
        }else{
            rcMap.put(root.parent.id,currentCount);
        }
    }
   
}
class Node{
    Node left;
    Node right;
    Node parent;
    int id = 0;//index
    public Node(){
    }
    public Node(Node left, Node right, Node parent){
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
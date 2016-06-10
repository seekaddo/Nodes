class IntTree {

    private class Node {

        int elem;
        Node left = null;
        Node right = null;

        Node(int elem) {
            this.elem = elem;
        }

        void add(int elem) {
            //TODO add code here
            if (elem < this.elem){
                if (this.left == null){
                    this.left = new Node(elem);
                }else {
                    this.left.add(elem);
                }
            }else {
                if (this.right == null){
                    this.right = new Node(elem);
                }else {
                    this.right.add(elem);
                }
            }
        }

        int countNodes() {
            //TODO add code here
            int nodes = 1;

            if (left != null)  nodes += left.countNodes();
            if (right != null) nodes += right.countNodes();

            return nodes;
        }

        int countLeaves() {
            //TODO add code here
            int leaves = 1; // if both nodes are null then return 1;
            if (left != null)  leaves += left.countLeaves();
            if (right != null) leaves += right.countLeaves();

            return leaves;
        }

        int height() {
            //TODO add code here
            if (this.elem == 0 && this.left == null && this.right == null) return 0; // if nothing in there


            int north = (this.left != null ? this.left.height() : 0); // 0 or 1 will work
            int south = (this.right != null ? this.right.height(): 0);

            if (this.left == null && this.right == null) return 1;
            if (north > south){
                return north + 1;
            }else {
                return south + 1;
            }

        }


        @Override
        //Todo: selbe dazu gemacht
        public String toString(){
            return this.elem + ((this.left != null) ?"-"+ this.left :"")+
                    (this.right != null ?"-"+this.right:"");
        }
    }

    private Node root = null;

    public void add(int elem) {
        //TODO add code here
        if (empty()){
            this.root = new Node(elem);
        }else {
            this.root.add(elem);
        }
    }

    public boolean empty() {
        return this.root == null;

    }

    public int countNodes() {
        //TODO add code here
        if (this.root == null){
            return 0;
        }

        return this.root.countNodes();
    }

    public int countLeaves() {
        //TODO add code here
        return (this.root != null)? this.root.countLeaves():0;

    }

    public int height() {
        //TODO add code here
        return this.root == null? 0:this.root.height();
    }
    @Override
    //Todo: selbe dazu gemacht
    public String toString(){
        return "["+ this.root +"]";
    }
}
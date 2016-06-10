class CharList {

    private class ListNode {
        char elem;
        ListNode next = null;
        ListNode prev = null;

        ListNode(char elem, ListNode next, ListNode prev) {
            //TODO add code here
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

        int getElem() {
            return this.elem;
        }
        ListNode getNext() {
            return this.next;
        }
        ListNode getPrev() {
            return this.prev;
        }

        void add(char elem) {
            //TODO add code here
            if (next == null){
                next = new ListNode(elem,null,this);
            }else {
                next.add(elem);
            }
        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "->" + this.next);
        }

    }

    private ListNode head = null;

    public boolean empty() {
        return this.head == null;
    }

    public void add(char elem) {
        //TODO add code here}
        if (head == null){
            head = new ListNode(elem,null,head);
        }else {
            this.head.add(elem);
        }
    }


    public boolean search(char value) {
        //TODO add code here
        ListNode sea = this.head;
        while (sea != null){
            if (sea.elem == value) {
                return true;
            }
            sea = sea.next;
        }

        return false;
    }

    public boolean insert(char value) {
        //TODO add code here

        ListNode check = head;
        while (check != null){
            if (value < check.elem && check.prev == null){
                head = new ListNode(value,head,null);
                return true;
            }else
            if (check.next != null && check.elem <= value && value <= check.next.elem){
                check.next = new ListNode(value,check.next,check);
                return true;

            }else if (check.next == null) {
                check.add(value);
                return true;
            }

            check = check.next;
        }
        return false;
    }

    public String toString() {
        return "[" + this.head + "]";
    }
}

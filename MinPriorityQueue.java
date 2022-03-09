import java.util.ArrayList;

class MinPriorityQueue
{
    // Keep the nodes in an ArrayList.  Two advantages
    // (1) We can store objects that store both value and priority
    // (2) We don't have to worry about expanding
    // PriQueueNode is defined at the bottom of this file.
    ArrayList<PriQueueNode> items;

    /**
     * Creates an empty priority queue
     */
    public MinPriorityQueue()
    {
       items = new ArrayList<PriQueueNode>();
    }
 
    /**
     * @return the item with the minimum priority
     */
    public Object peek()
    {
       return items.get(0).data;
    }
    
    /**
     * Removes and returns the item with the minimum priority
     * @return the item associated with the minimum priority
     */
    public Object dequeue()
    {
        if (items.size() > 1){
            Object removedval = items.get(0);
            items.set(0, items.remove(items.size()-1));
            bubbleDown(0);
            return removedval;
        } else {
            return items.remove(0);
        }

    }

    /**
     * Moves an item at the given index down the tree
     * As long as at least one of it's children is smaller
     * or we reach a leaf position.
     * @param idx the index of the item to move
     */
    protected void bubbleDown(int idx)
    {
        if (getMinChild(idx) > -1){
            if (items.get(idx).priority > items.get(getMinChild(idx)).priority){
                PriQueueNode temp = items.get(idx);
                items.set(idx, items.get(getMinChild(idx)));
                items.set(getMinChild(idx), temp);
                bubbleDown(getMinChild(idx));
            }
        }
    }
 
     /**
      * Returns index position of the child node
      * whose priority is smallest.
      * A given index may only have 1 or no children.
      */
    protected Integer getMinChild(int idx)
    {
        int leftChildIdx = (idx*2)+1;
        int rightChildIdx = (idx*2)+2;
        if (leftChildIdx >= items.size()){
            return -1;
        }
        if (rightChildIdx >= items.size()){
            return leftChildIdx;
        }
        if (items.get(leftChildIdx).priority < items.get(rightChildIdx).priority){
            return leftChildIdx;
        }
        return rightChildIdx;
    }
     
    /**
     * Inserts an item into the queue with the given priority
     * @param item the item to insert
     * @param priority the item's priority value
     */
    public void enqueue(double priority, Object val)
    {
        //The last thing in the list, is the last thing in the bottom layer
        PriQueueNode newItem = new PriQueueNode(priority, val);
        items.add(newItem);
        bubbleUp(items.size() - 1);
    }
 
    /**
     * Moves the item at the given index "up" the "tree" until its parent is smaller
     * @param idx the index of the item to move
     */
    protected void bubbleUp(int idx)
    {
        int parentIDX = (idx-1)/2; //if idx == 0, parent == 0, so priorities are the same!
        double parentPriority = items.get(parentIDX).priority;
        double currentPriority = items.get(idx).priority;
        if(currentPriority < parentPriority) {
            
            //Swap items
            PriQueueNode parent = items.get(parentIDX);
            PriQueueNode current = items.get(idx);
            items.set(parentIDX, current);
            items.set(idx, parent);
 
            bubbleUp(parentIDX); // Recursive implementation
        }
    }
 
    /**
     * @return a string representation of the heap
     */
    public String toString()
    {
        return items.toString();
    }
    
    public static void main(String [] args)
    {
        // Write tests here based on question two from previous in the lab
        // You can use arbitrary data (or perhaps null) for the "value" of each node
        // Make sure you use the same priorities, in the same order as in question two
        MinPriorityQueue queue = new MinPriorityQueue();
        queue.enqueue(12.2, 1);
        queue.enqueue(23.0, 2);
        queue.enqueue(9.0, 3);
        queue.enqueue(8.0, 4);
        queue.enqueue(12.0, 5);
        queue.enqueue(15.5, 6);
        for (int i = 0; i < queue.items.size(); i++){
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
    }
}

class PriQueueNode{

    // This object allows us to store the
    // data and the priority for this data 
    // together in "package" together
    //
    // +-PriQueueNode----+
    // | data: "hello!"  |
    // | pri: 2.4        |
    // +-----------------+
    public Object data;
    public double priority;

    public PriQueueNode(double pri, Object newVal){
        priority = pri;
        data = newVal;
    }

    public String toString(){
        return "(" + data + " {pri: " + priority + "})";
    }
}

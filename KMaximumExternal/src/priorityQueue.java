/**
 * Class to represent priority queue
 * 
 * @author SujitS
 */

class priorityQueue{
    int[] queue;
    int size;

    /**
     * Constructor for Priority Queue
     * 
     * @param n Size of the priority queue
     */
    public priorityQueue(int n) {
        queue = new int[n+1];
        size = 0;
    }

    /**
     * Function to add elements into the priority queue
     * 
     * @param x Element to be added
     */
    public void add(int x){
        queue[size+1] = x;
        size++;
        perculateUp(size);
    }

    /**
     * Function to re-arrange the heap order due to change in child element
     * 
     * @param index Element that violates the heap order
     */
    public void perculateUp(int index) {
        queue[0] = queue[index];
        while(queue[index/2]>queue[index]){
            swap(index/2,index);
            index = index/2;
        }
    }

    /**
     * Helper function to swap two elements in the queue
     * 
     * @param i Index position of element1
     * @param j Index position of element2
     */
    private void swap(int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    /**
     * Function to re-arrange the heap order due to change in parent
     * 
     * @param index Element that violates the heap order
     */
    public void perculateDown(int index){
        while(2*index <= size){
            if(queue[index]>queue[2*index]){
                if(2*index+1 <= size && queue[2*index]<queue[2*index+1]){
                    swap(index, 2*index);
                    index = 2*index;
                }
                else{
                    swap(index, 2*index+1);
                    index = 2*index+1;
                }
            }
            else if(2*index+1 <= size && queue[index]>queue[2*index+1]){
                swap(index, 2*index+1);
                index = 2*index+1;
            }
            else
                break;
        }
    }

}
public class stackWithTwoQueuesV1 {

    public myQueue q1;
    private myQueue q2;

    public stackWithTwoQueuesV1(int size){
        q1 = new myQueue(size);
        q2 = new myQueue(size);
    }

    public void push(int x){

        q2.enqueue(x);
        while(!q1.isEmpty()){
               q2.enqueue(q1.dequeue());
        }

        myQueue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop(){
        return q1.dequeue();
    }
}

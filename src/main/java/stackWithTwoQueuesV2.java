public class stackWithTwoQueuesV2 {

    public myQueue q1;
    private myQueue q2;

    public stackWithTwoQueuesV2(int size){
        q1 = new myQueue(size);
        q2 = new myQueue(size);
    }

    public void push(int x){
        q1.enqueue(x);
    }

    public int pop(){
        int q1Size = q1.size();
        for(int i=0; i<=q1Size-2; i++)
            q2.enqueue(q1.dequeue());

        myQueue temp = q1;
        q1 = q2;
        q2 = temp;

        return q2.dequeue();
    }
}

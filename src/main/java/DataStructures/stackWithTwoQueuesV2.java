package DataStructures;

import DataStructures.Queue;

public class stackWithTwoQueuesV2 {

    public Queue q1;
    private Queue q2;

    public stackWithTwoQueuesV2(int size){
        q1 = new Queue(size);
        q2 = new Queue(size);
    }

    public void push(int x){
        q1.enqueue(x);
    }

    public int pop(){
        int q1Size = q1.size();
        for(int i=0; i<=q1Size-2; i++)
            q2.enqueue(q1.dequeue());

        Queue temp = q1;
        q1 = q2;
        q2 = temp;

        return q2.dequeue();
    }
}

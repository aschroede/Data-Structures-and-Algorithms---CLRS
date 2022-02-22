package DataStructures;

import DataStructures.Queue;

public class stackWithTwoQueuesV1 {

    public Queue q1;
    private Queue q2;

    public stackWithTwoQueuesV1(int size){
        q1 = new Queue(size);
        q2 = new Queue(size);
    }

    public void push(int x){

        q2.enqueue(x);
        while(!q1.isEmpty()){
               q2.enqueue(q1.dequeue());
        }

        Queue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop(){
        return q1.dequeue();
    }
}

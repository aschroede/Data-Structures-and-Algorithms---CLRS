public class myQueue {

    private int [] Queue;
    public int Tail;
    private int Head;
    private int Capacity;

    public myQueue(int size){
        Capacity = size;
        Queue = new int[Capacity];
        Tail = 0;
        Head = 0;
    }

    public void enqueue(int x){

        if(isFull()){
            System.out.println("Queue overflow");
            return;
        }

        Queue[Tail] = x;
        if (Tail == Capacity -1)
            Tail = 0;
        else
            Tail += 1;
    }

    public int dequeue(){

        if(isEmpty()){
            System.out.println("Queue underflow");
            return 0;
        }

        int x = Queue[Head];
        if(Head == Capacity -1)
            Head = 0;
        else
            Head += 1;
        return x;
    }

    public boolean isEmpty(){
        if(Head == Tail)
            return true;
        return false;
    }

    public boolean isFull(){
        if (Head == Tail +1)
            return true;
        if(Head ==0 && Tail== Capacity -1)
            return true;
        return false;
    }

    public void printQueue(){

        if(Head < Tail){
            for(int i=Head; i< Tail; i++ ){
                System.out.print(Queue[i] + ", ");
            }
        }

        else if(Tail < Head){
            for(int i = Head; i<= Capacity -1; i++)
                System.out.print(Queue[i] + ", ");
            for(int i = 0; i<Tail; i++)
                System.out.print(Queue[i] + ", ");
        }

        else
            return;
    }

    public int size(){

        if(Tail > Head){
            return Tail - Head;
        }
        else if(Head > Tail){
            return Capacity - Head + Tail;
        }
        else
            return 0;
    }


}

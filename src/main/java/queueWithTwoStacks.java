public class queueWithTwoStacks {

    private myStack inputStack;
    private myStack outputStack;

    public queueWithTwoStacks(int size){
        inputStack = new myStack(size);
        outputStack = new myStack(size);
    }

    public void enqueue(int x){
        inputStack.push(x);
    }

    public int dequeue(){
        if(outputStack.isEmpty()){
            int initialSize = inputStack.top;
            for(int i = 0; i<= initialSize; i++)
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }

    public void printQueue(){
        System.out.print("Queue: ");
        outputStack.printStackReverse();
        inputStack.printStack();
        System.out.print("\n");
    }
}

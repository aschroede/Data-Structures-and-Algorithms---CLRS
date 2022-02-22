package DataStructures;

import DataStructures.Stack;

public class queueWithTwoStacks {

    private Stack inputStack;
    private Stack outputStack;

    public queueWithTwoStacks(int size){
        inputStack = new Stack(size);
        outputStack = new Stack(size);
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
        System.out.print("DataStructures.Queue: ");
        outputStack.printStackReverse();
        inputStack.printStack();
        System.out.print("\n");
    }
}

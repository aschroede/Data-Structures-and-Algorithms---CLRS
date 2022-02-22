package DataStructures;

public class Stack {

    public int [] m_Stack;
    public int top;
    private int size;

    public Stack(int Size) {
        size = Size;
        m_Stack = new int[size];
        top = -1;
    }

    public boolean isEmpty(){
        if (top == -1)
                return true;
        return false;
    }

    public boolean isFull(){
        if(top == size -1){
            return true;
        }
        return  false;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("DataStructures.Stack overflow");
            return;
        }
        top += 1;
        m_Stack[top] = x;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("DataStructures.Stack underflow");
            return 0;
        }

        else{
            top -= 1;
            return m_Stack[top+1];
        }
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(m_Stack[i] + ", ");
        }
    }

    public void printStackReverse() {
        for (int i = top; i >= 0; i--) {
            System.out.print(m_Stack[i] + ", ");
        }
    }

}

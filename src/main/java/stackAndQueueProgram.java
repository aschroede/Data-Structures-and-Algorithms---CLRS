import java.util.Arrays;
import java.util.Scanner;

public class stackAndQueueProgram {

    public static void commandPrompt(){
        System.out.println("Enter a command");
    }

    public static void main(String[] args){

        String dataStructure;
        myQueue aQueue = new myQueue(5);
        queueWithTwoStacks TwoQueue = new queueWithTwoStacks(5);
        stackWithTwoQueuesV1 TwoStack_V1 = new stackWithTwoQueuesV1(5);
        stackWithTwoQueuesV2 TwoStack_V2 = new stackWithTwoQueuesV2(5);
        myStack aStack = new myStack(10);
        Scanner in = new Scanner(System.in);

        System.out.println("Please select data structure: queue, queue2, or stack");
        String s1 = in.nextLine();

        if (s1.contains("stack2_V1")){
            while(true){

                commandPrompt();
                String s2 = in.nextLine();

                if(s2.contains("pop")){
                    System.out.println(TwoStack_V1.pop());
                    TwoStack_V1.q1.printQueue();
                }

                else if(s2.contains("push")){
                    String [] segments = s2.split(" ");
                    TwoStack_V1.push(Integer.parseInt(segments[1]));
                    TwoStack_V1.q1.printQueue();
                }
            }
        }

        if (s1.contains("stack2_V2")){
            while(true){

                commandPrompt();
                String s2 = in.nextLine();

                if(s2.contains("pop")){
                    System.out.println(TwoStack_V2.pop());
                    TwoStack_V2.q1.printQueue();
                }

                else if(s2.contains("push")){
                    String [] segments = s2.split(" ");
                    TwoStack_V2.push(Integer.parseInt(segments[1]));
                    TwoStack_V2.q1.printQueue();
                }
            }
        }

        if (s1.contains("stack")){
            while(true){

                commandPrompt();
                String s2 = in.nextLine();

                if(s2.contains("pop")){
                    System.out.println(aStack.pop());
                    System.out.println(Arrays.toString(aStack.m_Stack));
                }

                else if(s2.contains("push")){
                    String [] segments = s2.split(" ");
                    aStack.push(Integer.parseInt(segments[1]));
                    System.out.println(Arrays.toString(aStack.m_Stack));
                }
            }
        }

        else if (s1.contains("queue2")){
            while(true){

                commandPrompt();
                String s2 = in.nextLine();

                if(s2.contains("deq")){
                    System.out.println("Dequeued value: "+ TwoQueue.dequeue());
                    TwoQueue.printQueue();
                }

                else if(s2.contains("qu")){
                    String [] segments = s2.split(" ");
                    TwoQueue.enqueue(Integer.parseInt(segments[1]));
                    TwoQueue.printQueue();
                }
            }
        }

        else if(s1.contains("queue")){
            while(true){

                commandPrompt();
                String s2 = in.nextLine();

                if(s2.contains("deq")){
                    aQueue.dequeue();
                    aQueue.printQueue();
                }

                else if(s2.contains("qu")){
                    String [] segments = s2.split(" ");
                    aQueue.enqueue(Integer.parseInt(segments[1]));
                    aQueue.printQueue();
                }
            }
        }
    }
}

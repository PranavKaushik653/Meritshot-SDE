package Circular_Queue;

import java.util.Scanner;

public class DesignCircularQueue {
    static class CircularQueue{
        int [] arr;
        int front,rear,size,capacity;
        CircularQueue(int k){
            capacity=k;
            arr=new int[k];
            front=0;
            rear=-1;
            size=0;
        }
        boolean enQueue(int value){
            if(isFull())return false;
            rear=(rear+1)%capacity;
            arr[rear]=value;
            size++;
            return true;
        }
        boolean deQueue(){
            if(isEmpty())return false;
            rear=(rear-1+capacity)%capacity;
            size--;
            return true;
        }
        int Front(){
            if(isEmpty())return -1;
            return arr[front];
        }
        int Rear(){
            if(isEmpty())return -1;
            return arr[rear];
        }
        boolean isFull(){
            return size==capacity;
        }
        boolean isEmpty(){
            return size==0;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=Integer.parseInt(sc.nextLine().trim());
        CircularQueue cqueue=new CircularQueue(k);

        while(sc.hasNextLine()){
            String op=sc.nextLine().trim();
            if(op.isEmpty())break;

            if(op.startsWith("enQueue")){
                int val=Integer.parseInt(op.substring(8,op.length()-1));
                cqueue.enQueue(val);
            }
            else if (op.equals("deQueue()")) {
                cqueue.deQueue();
            }
            else if (op.equals("Front()")) {
                System.out.println(cqueue.Front());
            }
            else if (op.equals("Rear()")) {
                System.out.println(cqueue.Rear());
            }
            else if (op.equals("isEmpty()")) {
                System.out.println(cqueue.isEmpty());
            }
            else if (op.equals("isFull()")) {
                System.out.println(cqueue.isFull());
            }
        }
    }
}

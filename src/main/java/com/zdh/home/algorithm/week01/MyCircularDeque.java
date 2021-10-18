package com.zdh.home.algorithm.week01;

class MyCircularDeque {

    private int length;
    private int capacity;
    private ListNode head;
    private ListNode end;


    MyCircularDeque(int k) {

    }

    Boolean insertFront(int value) {

    }

    Boolean insertLast(int value) {

    }

    Boolean deleteFront() {

    }

    Boolean deleteLast() {

    }

    int getFront() {

    }

    int getRear() {

    }

    Boolean isEmpty() {

    }

    Boolean isFull() {

    }

    public class ListNode {


        int val;
        MergeLinkedList.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, MergeLinkedList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
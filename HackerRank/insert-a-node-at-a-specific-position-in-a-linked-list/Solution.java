static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    SinglyLinkedListNode initialHead = head;  // save initial head for future reference

    SinglyLinkedListNode nodeToAdd = new SinglyLinkedListNode(data);  // make a new node for new data
    if (position == 0) {  // adding as the first element
        if (head != null) nodeToAdd.next = head;  // add to the start if head exists
        return nodeToAdd;  // return new head
    }

    int currentPosition = 0;
    // go through list until desired position has been reached
    while (currentPosition < position - 1 && head.next != null) {
        head = head.next;
        currentPosition++;
    }

    SinglyLinkedListNode oldNodeAtPosition = head.next;  // save the node that currently is at the position
    head.next = nodeToAdd;  // add new node at the position
    head = head.next;  // save new node as head now
    head.next = oldNodeAtPosition;  // add old node as new nodes next node

    return initialHead;
}

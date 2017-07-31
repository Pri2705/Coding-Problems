/*
There are two singly linked lists in a system. By some programming error the end node of one of the linked list 
got linked into the second list, forming a inverted Y shaped list. Write a program to get the point where two linked lists
merge.
Expected time complexity is O(m + n) where m and n are lengths of two linked lists
*/

/*
Approach: 
traverse first LL and make it cyclic.
move pointer from head of 2nd ll for the length of the first LL (or length of cycle).
move head of 2nd LL and the step 2 pointer together until they both reach same node
*/

class GFG
{
	int intersectPoint(Node headA, Node headB)
	{
         // code here
         Node temp = headA;
         int cycleLength = 0;
         while(temp.next!=null){
             temp=temp.next;
             cycleLength++;
         }
         cycleLength++;
         temp.next = headA;
         Node temp2 = headB;
         for(int i=0; i<cycleLength; i++){
             temp2 = temp2.next;
         }
         while(temp2!=headB){
             temp2 = temp2.next;
             headB = headB.next;
         }
         return temp2.data;
	}
}

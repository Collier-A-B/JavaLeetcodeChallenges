package linked_list_lib;

/**
 * ListNode class provided within certain leet code challenges
 * 
 * NOTE: access modifiers have been changed from package default to public
 * 
 */
public class ListNode {
    public int val;             
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

package mergeksortedlists;


class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        // head of the returned list
        ListNode returnList = null;

        ListNode currentNode = null;
        int lowestValIndx = -1;
        while (true) { 
            int lowestVal = Integer.MAX_VALUE;
            
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null && lists[i].val < lowestVal)
                {
                    lowestVal = lists[i].val;
                    lowestValIndx = i;
                }
            }
            if (lowestVal == Integer.MAX_VALUE)
                break;

            ListNode newNode = new ListNode(lowestVal);
            lists[lowestValIndx] = lists[lowestValIndx].next;

            if (returnList == null) {
                returnList = newNode;
                currentNode = returnList;
            }
            else {
                currentNode.next = newNode;
                currentNode = newNode;
            }
        } 

        return returnList;
    }
}

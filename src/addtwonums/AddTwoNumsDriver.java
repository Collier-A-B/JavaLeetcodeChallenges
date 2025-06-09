package addtwonums;

public class AddTwoNumsDriver {
    public static void main(String[] args) {
        // list representation of 342
        int[] list1 = {2, 4, 3};
        // list representation of 465
        int[] list2 = {5, 6, 4};
        // List representation of expected result (807)
        int[] expected = {7, 0, 8};

        // Test 1 (342 + 465)
        test(list1, list2, 1, expected); 
    }

    private static ListNode makeList(int[] list){
        // convert list 1 to linked-list
        ListNode listRoot = null;

        // current node being created
        ListNode listNewNode = null;

        // Last Node Created
        ListNode listLastNode = null;
        for(int i = 0; i < list.length; i++){
            listNewNode = new ListNode(list[i]);
            if (i == 0)
                listRoot = listNewNode;
            else 
                listLastNode.next = listNewNode;
            listLastNode = listNewNode;
        }

        return listRoot;
    }

    private static void test(int[] l1, int[] l2, int testNum, int[] expected) {
        System.out.println("******************Test "+testNum+" ******************");
        
        // create new nodes 
        ListNode l1Root = makeList(l1);
        ListNode l2Root = makeList(l2);

        // run my solution
        ListNode result = Solution.addTwoNumbers(l1Root, l2Root);

        // compare result to expected
        for (int elem : expected){
            System.out.println("Expected: " + elem);
            System.out.println("Result:   " + result.val);
            System.out.println("Digits match: " + (elem == result.val));
            assert(elem == result.val);
            result = result.next;
        }

    }
}

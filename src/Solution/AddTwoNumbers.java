package Solution;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int extra, sum;
        extra=0;
        ListNode result, ptr, ptr_l1, ptr_l2;
        ptr_l1=l1;
        ptr_l2=l2;
        ptr=null;
        result=null;
        // the main part
        while (ptr_l1!=null && ptr_l2!=null)
        {
            sum=ptr_l1.val+ptr_l2.val+extra;
            extra=sum/10;
            sum=sum%10;
            if (result==null)
            {
                ptr=new ListNode(sum);
                result=ptr;
            }
            else
            {
                ptr.next=new ListNode(sum);
                ptr=ptr.next;
            }
            ptr_l1=ptr_l1.next;
            ptr_l2=ptr_l2.next;
        }
        // for the other case, e.g, one of the list is unfinished
        while (ptr_l1!=null)
        {
            sum=ptr_l1.val+extra;
            extra=sum/10;
            sum=sum%10;
            if (result==null)
            {
                ptr=new ListNode(sum);
                result=ptr;
            }
            else
            {
                ptr.next=new ListNode(sum);
                ptr=ptr.next;
            }
            ptr_l1=ptr_l1.next;
        }
        while(ptr_l2!=null)
        {
            sum=ptr_l2.val+extra;
            extra=sum/10;
            sum=sum%10;
            if (result==null)
            {
                ptr=new ListNode(sum);
                result=ptr;
            }
            else
            {
                ptr.next=new ListNode(sum);
                ptr=ptr.next;
            }
            ptr_l2=ptr_l2.next;
        }
        // for the increment
        if (extra>0)
        {
            if (result==null)
            {
                ptr=new ListNode(extra);
                result=ptr;
            }
            else
            {
                ptr.next=new ListNode(extra);
                ptr=ptr.next;
            }
        }
        return result;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
 }
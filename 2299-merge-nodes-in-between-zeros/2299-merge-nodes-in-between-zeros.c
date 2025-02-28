/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeNodes(struct ListNode* head) {
    head=head->next;
    struct ListNode* temp1;
    temp1=head;
    while(temp1)
    {
      struct ListNode* temp2;
      temp2=temp1;
      int sum=0;
      while(temp2->val!=0)
      {
        sum=sum+temp2->val;
        temp2=temp2->next;
      }
      temp1->val=sum;
      temp1->next=temp2->next;
      temp1=temp1->next;
    }
    return head;
}
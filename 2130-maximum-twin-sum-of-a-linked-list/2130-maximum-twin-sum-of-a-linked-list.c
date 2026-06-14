/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 struct ListNode* reversell(struct ListNode* head)
 {
    struct ListNode* rev,*nextn,*temp;
    rev=nextn=NULL;
    temp=head;
    while(temp!=NULL)
    {
        nextn=temp->next;
        temp->next=rev;
        rev=temp;
        temp=nextn;
    }
    return rev;
 }
int pairSum(struct ListNode* head) {
    struct ListNode *slow,*fast;
    slow=fast=head;
    while(fast!=NULL&&fast->next!=NULL)
    {
        slow=slow->next;
        fast=fast->next->next;
    }
    struct ListNode* secondhalf;
    secondhalf=reversell(slow);
    struct ListNode* firsthalf;
    firsthalf=head;
    int maxsum=INT_MIN;
    while(secondhalf!=NULL)
    {
       int currsum=firsthalf->val+secondhalf->val;
       if(currsum>maxsum)
       {
        maxsum=currsum;
       }
       firsthalf=firsthalf->next;
       secondhalf=secondhalf->next;
    }
    return maxsum;
}
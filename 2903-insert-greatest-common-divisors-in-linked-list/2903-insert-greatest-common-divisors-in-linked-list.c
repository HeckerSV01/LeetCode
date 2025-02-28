/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 int gcd(int* val1,int* val2)
 {
    int minval;
    if(*val1>*val2)
    {
       minval=*val2;
    }
    else
    {
        minval=*val1;
    }
    int maxdiv=1;
    for(int i=1;i<=minval;i++)
    {
        if(*val1%i==0&&*val2%i==0)
        {
            maxdiv=i;
        }
    }
    return maxdiv;
 }
struct ListNode* insertGreatestCommonDivisors(struct ListNode* head) {
    struct ListNode* temp;
    temp=head;
    while(temp->next!=NULL)
    {
        struct ListNode* inserted;
        inserted=(struct ListNode*)malloc(sizeof(struct ListNode));
        inserted->val=gcd(&temp->val,&temp->next->val);
        inserted->next=temp->next;
        temp->next=inserted;
        temp=temp->next->next;
    }
    return head;
}
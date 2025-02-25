/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* mergeInBetween(struct ListNode* list1, int a, int b, struct ListNode* list2){
struct ListNode* temp1,* temp2;
temp1=list1;
int count=1;
while(count!=a)
{
    temp1=temp1->next;
    count++;
} 
temp2=temp1->next;
int count2=1;
while(count2!=b-a+1)
{
temp2=temp2->next;
count2++;
}
temp2=temp2->next;
temp1->next=list2;
while(list2->next!=NULL)
{
    list2=list2->next;
}
list2->next=temp2;
return list1;
}
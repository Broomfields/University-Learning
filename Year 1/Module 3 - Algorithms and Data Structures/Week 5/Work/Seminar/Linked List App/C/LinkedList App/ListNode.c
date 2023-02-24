// ListNode.cpp
// class ListNode representing a node with information and link fields
// taken from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class

#include "ListNode.h"

// Constructors
// postcondition: Creates a new empty node
ListNode::ListNode()
{
        data = 0;
        next = nullptr;
}

// postcondition: Creates a new node storing obj
ListNode::ListNode(int obj)
{
        data = obj;
        next = nullptr;
}

// postcondition: Creates a new node storing obj
// and linked to node referenced by link.
ListNode::ListNode(int obj, ListNode *nxt)
{
        data = obj;
        next = nxt;
}
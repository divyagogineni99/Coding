package com.SpringIntro.ConstructorInjection.collection.Stack;

import com.SpringIntro.ConstructorInjection.collection.Collection;

public interface Stack extends Collection {
    int push(int element);

    int pop();

    int peek();

    String min();

    String print();

    void clear();

//    char pushReverseString(char element);
//
//    char popReverseString();
}

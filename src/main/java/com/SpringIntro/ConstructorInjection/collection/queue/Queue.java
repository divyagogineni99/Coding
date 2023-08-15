package com.SpringIntro.ConstructorInjection.collection.queue;

import com.SpringIntro.ConstructorInjection.collection.Collection;

public interface Queue extends Collection {

    int dequeue();
    String enqueue(int element);
    String peek();
    String lookup(int lookupElement);
    String print();
    void clear();


}

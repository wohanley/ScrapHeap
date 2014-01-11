package com.wohanley.ScrapHeap.main.scraps;

public interface Clause
{
    String getText();
    
    Clause next();
    Clause previous();
}

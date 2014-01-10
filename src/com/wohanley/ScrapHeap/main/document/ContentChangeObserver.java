package com.wohanley.ScrapHeap.main.document;

import javax.swing.undo.UndoableEdit;

public interface ContentChangeObserver
{
    void stringInserted(UndoableEdit edit);
    
    void stringRemoved(UndoableEdit edit);
}

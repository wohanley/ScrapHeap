package com.wohanley.ScrapHeap.startup;

import com.wohanley.ScrapHeap.PlainScrapHeapModel;
import com.wohanley.ScrapHeap.gui.MainWindow;

public class Driver
{
    public static void main(String[] args)
    {
        MainWindow frame = new MainWindow(new PlainScrapHeapModel());
    }
}

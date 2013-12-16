package com.wohanley.ScrapHeap.main.startup;

import com.wohanley.ScrapHeap.main.PlainScrapHeapModel;
import com.wohanley.ScrapHeap.main.gui.MainWindow;

public class Driver
{
    public static void main(String[] args)
    {
        MainWindow frame = new MainWindow(new PlainScrapHeapModel());
    }
}

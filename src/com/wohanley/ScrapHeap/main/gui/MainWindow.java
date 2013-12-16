package com.wohanley.ScrapHeap.main.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.wohanley.ScrapHeap.main.ScrapHeapModel;

public class MainWindow extends JFrame
{
    private ScrapHeapModel model;
    
    public MainWindow(ScrapHeapModel model)
    {
        super();
        this.model = model;
        
        this.setPreferredSize(new Dimension(300, 300));
        this.setVisible(true);
        this.pack();
    }
}

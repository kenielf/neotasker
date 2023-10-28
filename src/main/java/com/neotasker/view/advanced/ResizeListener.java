package com.neotasker.view.advanced;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;

public class ResizeListener implements ComponentListener {
    public Dimension componentDimension;
    @Override
    public void componentHidden(ComponentEvent e) {}
    @Override
    public void componentMoved(ComponentEvent e) {}
    @Override
    public void componentShown(ComponentEvent e) {}
    @Override
    public void componentResized(ComponentEvent e) {
        this.componentDimension = e.getComponent().getBounds().getSize();          
        //System.out.format(
        //    "\r\u001b[K[%s] Current Size: %dx%d", LocalDateTime.now(), 
        //    this.componentDimension.width, this.componentDimension.height
        //);
    }
}

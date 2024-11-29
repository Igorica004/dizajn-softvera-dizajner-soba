package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.factory.Prototype;

import java.awt.*;

public abstract class ElementPainter {
    protected Prototype prototype;
    public ElementPainter(Prototype prototype) {
        this.prototype = prototype;
    }
    public abstract void paint(Graphics2D g, Prototype prototype);
}

package open.gl.lab;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import open.gl.lab.lab1.Initials;
import open.gl.lab.lab2.BezierLetter;
import open.gl.lab.lab2.Heart;
import open.gl.lab.lab2.Nurbs;

import javax.swing.JFrame;

public class Main {

    public static void main(final String arg[]) {

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        final GLCanvas glcanvas = new GLCanvas(capabilities);
        //final Initials view = new Initials();
        //final Heart view = new Heart();
        //final Nurbs view = new Nurbs();
        final BezierLetter view = new BezierLetter();

        glcanvas.addGLEventListener(view);
        glcanvas.setSize(400, 400);

        final JFrame frame = new JFrame ("straight Line");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
    }
}

package open.gl.lab.parent;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

public abstract class AbstractListener implements GLEventListener {

    private GLU glu;
    private GL2 gl2;

    @Override
    public void init(final GLAutoDrawable glAutoDrawable) {
        gl2 = glAutoDrawable.getGL().getGL2();
        gl2.glMatrixMode(GL_PROJECTION);
        gl2.glLoadIdentity();

        glu = new GLU();
        glu.gluOrtho2D(-5.0f, 5.0f, -5.0f, 5.0f);
        //glu.gluOrtho2D(0f, 100f, 0f, 100f);

        gl2.glMatrixMode(GL_MODELVIEW);
        gl2.glLoadIdentity();
        gl2.glClearColor(1f, 1f, 1f, 0f);
        gl2.glDisable(GL.GL_DEPTH_TEST);
    }

    public GLU getGlu() {
        return glu;
    }

    public GL2 getGl2() {
        return gl2;
    }
}

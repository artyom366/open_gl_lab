package open.gl.lab.parent;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.gl2.GLUgl2;

import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

public abstract class AbstractListener implements GLEventListener {

    private GLU glu;
    private GL2 gl2;
    private GLUgl2 glUgl2;

    @Override
    public void init(final GLAutoDrawable glAutoDrawable) {
        gl2 = glAutoDrawable.getGL().getGL2();
        gl2.glMatrixMode(GL_PROJECTION);
        gl2.glLoadIdentity();

        glu = new GLU();
        glu.gluOrtho2D(-5.0f, 5.0f, -5.0f, 5.0f);

        glUgl2 = new GLUgl2();

        gl2.glMatrixMode(GL_MODELVIEW);
        gl2.glLoadIdentity();
        gl2.glClearColor(1f, 1f, 1f, 0f);
        gl2.glDisable(GL.GL_DEPTH_TEST);
        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
    }

    public GLU getGlu() {
        return this.glu;
    }

    public GL2 getGl2() {
        return this.gl2;
    }

    public GLUgl2 getGlUgl2() {
        return this.glUgl2;
    }
}

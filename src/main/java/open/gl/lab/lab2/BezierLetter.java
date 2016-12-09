package open.gl.lab.lab2;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.GLBuffers;
import open.gl.lab.parent.AbstractListener;

import java.nio.FloatBuffer;

public class BezierLetter extends AbstractListener {

    private GL2 gl2;

    @Override
    public void init(final GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable);
        this.gl2 = getGl2();



    }

    @Override
    public void dispose(final GLAutoDrawable glAutoDrawable) {
    }

    @Override
    public void display(final GLAutoDrawable glAutoDrawable) {

        //Lines
        gl2.glBegin(GL2.GL_LINES);
        {
            gl2.glVertex2f(-0.5f, 2.0f);
            gl2.glVertex2f(-1.0f, 0.0f);

            gl2.glVertex2f(0.5f, 2.0f);
            gl2.glVertex2f(1.0f, 0.0f);

            gl2.glVertex2f(-0.65f, 1.3f);
            gl2.glVertex2f(0.65f, 1.3f);

            gl2.glVertex2f(1.5f, 3.0f);
            gl2.glVertex2f(1.5f, 0.0f);

        }
        gl2.glEnd();

        //A
        final float aLetter[][] = {{-1f, 0.0f, 2.0f}, {0.0f, 4.0f, 0.0f}, {0.0f, 4.0f, 0.0f}, {1f, 0.0f, 2.0f}};
        final FloatBuffer aLetterBuffer = GLBuffers.newDirectFloatBuffer(aLetter[0].length * aLetter.length);
        for (final float[] aLetterPoint : aLetter) {
            aLetterBuffer.put(aLetterPoint);
        }
        aLetterBuffer.rewind();

        gl2.glShadeModel(GL2.GL_FLAT);
        gl2.glMap1f(GL2.GL_MAP1_VERTEX_3, 0.0f, 1.0f, 3, 4, aLetterBuffer);
        gl2.glEnable(GL2.GL_MAP1_VERTEX_3);

        gl2.glBegin(GL2.GL_LINE_STRIP);
        {
            for (int i = 0; i <= 30; i++) {
                gl2.glEvalCoord1f((float) i / (float) 30.0);
            }
        }
        gl2.glEnd();

        //R
        final float rLetter[][] = {{1.5f, 3.0f, 1.0f}, {3.5f, 2.5f, 1.0f}, {3.5f, 1.5f, 1.0f}, {1.5f, 1.0f, 0.0f}};
        final FloatBuffer rLetterBuffer = GLBuffers.newDirectFloatBuffer(rLetter[0].length * rLetter.length);
        for (final float[] rLetterPoint : rLetter) {
            rLetterBuffer.put(rLetterPoint);
        }
        rLetterBuffer.rewind();

        gl2.glShadeModel(GL2.GL_FLAT);
        gl2.glMap1f(GL2.GL_MAP1_VERTEX_3, 0.0f, 1.0f, 3, 4, rLetterBuffer);
        gl2.glEnable(GL2.GL_MAP1_VERTEX_3);

        gl2.glBegin(GL2.GL_LINE_STRIP);
        {
            for (int i = 0; i <= 30; i++) {
                gl2.glEvalCoord1f((float) i / (float) 30.0);
            }
        }
        gl2.glEnd();
    }

    @Override
    public void reshape(final GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
    }
}

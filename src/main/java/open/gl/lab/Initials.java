package open.gl.lab;


import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;
import static open.gl.lab.Coordinate.*;

public class Initials implements GLEventListener {

    private Coordinate current;
    private GLU glu;
    private GL2 gl2;

    @Override
    public void init(final GLAutoDrawable glAutoDrawable) {

        gl2 = glAutoDrawable.getGL().getGL2();
        gl2.glMatrixMode(GL_PROJECTION);
        gl2.glLoadIdentity();

        glu = new GLU();
        glu.gluOrtho2D(0f, 100f, 0f, 100f);

        gl2.glMatrixMode(GL_MODELVIEW);
        gl2.glLoadIdentity();
        gl2.glClearColor(1f, 1f, 1f, 0f);
        gl2.glDisable(GL.GL_DEPTH_TEST);
    }

    @Override
    public void dispose(final GLAutoDrawable glAutoDrawable) {
    }

    @Override
    public void display(final GLAutoDrawable glAutoDrawable) {
        gl2.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl2.glColor3f(0f, 0f, 0f);

        drawLetter(getLetterACoordinates(), getLetterACodes(), GL2.GL_CLIP_PLANE0, new double[]{0.7, -1.5, 20.0, 40});
        drawLetter(getLetterRCoordinates(), getterRCodes(), GL2.GL_CLIP_PLANE0, new double[]{0.5, -1.5, 20.0, 40});
    }

    private void drawLetter(final Coordinate[] coordinates, final int[] codes, final int clipPlane, final double[] clippingPlaneCoordinates) {
        current = new Coordinate(coordinates[0].getX(), coordinates[0].getY());

        gl2.glPushMatrix();
        {
            gl2.glGetIntegerv(clipPlane, new int[]{1}, 0);
            gl2.glClipPlane(clipPlane, clippingPlaneCoordinates, 0);
            gl2.glEnable(clipPlane);

            for (int code : codes) {
                if (code < 0) {
                    moveCurrent(coordinates[Math.abs(code)]);
                } else {
                    drawLine(coordinates[code]);
                }
            }

            gl2.glDisable(clipPlane);
        }
        gl2.glPopMatrix();

        gl2.glFlush();
    }

    private void drawLine(final Coordinate coordinate) {

        gl2.glBegin(GL.GL_LINES);
        {
            gl2.glVertex2f(current.getX(), current.getY());
            gl2.glVertex2f(coordinate.getX(), coordinate.getY());
            System.out.println(String.format("Form: x-%s y-%s, To: x-%s y-%s", current.getX(), current.getY(), coordinate.getX(), coordinate.getY()));

            moveCurrent(coordinate);
        }
        gl2.glEnd();
    }

    private void moveCurrent(final Coordinate coordinate) {
        current.setX(coordinate.getX());
        current.setY(coordinate.getY());
    }

    @Override
    public void reshape(final GLAutoDrawable glAutoDrawable, final int i, final int i1, final int i2, final int i3) {
    }
}

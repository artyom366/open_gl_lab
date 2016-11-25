package open.gl.lab;


import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

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

        drawLetter(getLetterAOuterCoordinates(), getLetterAOuterCodes());
        drawLetter(getLetterAInnerCoordinates(), getLetterAInnerCodes());
        drawLetter(getLetterROuterCoordinates(), getterROuterCodes());
        drawLetter(getLetterRInnerCoordinates(), getterRInnerCodes());

    }

    private void drawLetter(final Coordinate[] coordinates, final int[] codes) {
        current = new Coordinate(coordinates[0].getX(), coordinates[0].getY());

        for (int code : codes) {
            drawLine(coordinates[code]);
        }
    }

    private void drawLine(final Coordinate coordinate) {

        gl2.glPushMatrix();
        {
            gl2.glBegin(GL.GL_LINES);
            {
                gl2.glVertex2f(current.getX(), current.getY());
                gl2.glVertex2f(coordinate.getX(), coordinate.getY());
                moveCurrent(coordinate.getX(), coordinate.getY());
            }
            gl2.glEnd();
        }
        gl2.glPopMatrix();
    }

    private void moveCurrent(final float x, final float y) {
        current.setX(x);
        current.setY(y);
    }

    @Override
    public void reshape(final GLAutoDrawable glAutoDrawable, final int i, final int i1, final int i2, final int i3) {
    }
}

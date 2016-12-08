package open.gl.lab.lab2;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.GLBuffers;
import open.gl.lab.parent.AbstractListener;

import java.nio.FloatBuffer;

import static open.gl.lab.stat.Coordinate.*;
import static open.gl.lab.stat.Coordinate.getLeftHeartSide;

public class Heart extends AbstractListener {

    private float leftPoints[][] = getLeftHeartSide();
    private float rightPoints[][] = getRightHeartSide();
    private FloatBuffer leftBuffer;
    private FloatBuffer rightBuffer;

    private GL2 gl2;

    @Override
    public void init(final GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable);
        this.gl2 = getGl2();

        gl2.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl2.glColor3f(1.0f, 1.0f, 1.0f);

        leftBuffer = GLBuffers.newDirectFloatBuffer(leftPoints[0].length * leftPoints.length);
        for (float[] leftPoint : leftPoints) {
            leftBuffer.put(leftPoint);
        }
        leftBuffer.rewind();

        rightBuffer = GLBuffers.newDirectFloatBuffer(rightPoints[0].length * rightPoints.length);
        for (float[] rightPoint : rightPoints) {
            rightBuffer.put(rightPoint);
        }
        rightBuffer.rewind();
    }

    @Override
    public void dispose(final GLAutoDrawable glAutoDrawable) {}

    @Override
    public void display(final GLAutoDrawable glAutoDrawable) {

        gl2.glShadeModel(GL2.GL_FLAT);
        gl2.glMap1f(GL2.GL_MAP1_VERTEX_3, 0.0f, 1.0f, 3, 4, leftBuffer);
        gl2.glEnable(GL2.GL_MAP1_VERTEX_3);

        gl2.glBegin(GL2.GL_LINE_STRIP);
        for (int i = 0; i <= 30; i++) {
            gl2.glEvalCoord1f((float) i / (float) 30.0);
        }
        gl2.glEnd();

//        gl2.glPointSize(5.0f);
//        gl2.glColor3f(1.0f, 1.0f, 0.0f);
//        gl2.glBegin(GL2.GL_POINTS);
//        for (int i = 0; i < 4; i++) {
//            gl2.glVertex3fv(leftBuffer);
//            leftBuffer.position(i * 3);
//        }
//        gl2.glEnd();

        gl2.glShadeModel(GL2.GL_FLAT);
        gl2.glMap1f(GL2.GL_MAP1_VERTEX_3, 0.0f, 1.0f, 3, 4, rightBuffer);
        gl2.glEnable(GL2.GL_MAP1_VERTEX_3);

        gl2.glBegin(GL2.GL_LINE_STRIP);
        for (int i = 0; i <= 30; i++) {
            gl2.glEvalCoord1f((float) i / (float) 30.0);
        }
        gl2.glEnd();

//        gl2.glPointSize(5.0f);
//        gl2.glColor3f(1.0f, 1.0f, 0.0f);
//        gl2.glBegin(GL2.GL_POINTS);
//        for (int i = 0; i < 4; i++) {
//            gl2.glVertex3fv(rightBuffer);
//            rightBuffer.position(i * 3);
//        }
//        gl2.glEnd();

        gl2.glFlush();
    }

    @Override
    public void reshape(final GLAutoDrawable glAutoDrawable, int x, int y, int w, int h) {}
}

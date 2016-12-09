package open.gl.lab.lab2;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLUnurbs;
import com.jogamp.opengl.glu.gl2.GLUgl2;
import open.gl.lab.parent.AbstractListener;

import static open.gl.lab.stat.Coordinate.*;

public class Nurbs extends AbstractListener {

    private float leftPoints[] = getLeftHeartSideFlat();
    private float rightPoints[] = getRightHeartSideFlat();
    private float heartPoints[] = getHeartPoints();

    private GL2 gl2;
    private GLUgl2 glUgl2;

    @Override
    public void init(final GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable);
        this.gl2 = getGl2();
        this.glUgl2 = getGlUgl2();
    }

    @Override
    public void dispose(final GLAutoDrawable glAutoDrawable) {}

    @Override
    public void display(final GLAutoDrawable glAutoDrawable) {
        GLUnurbs gluNurbs = glUgl2.gluNewNurbsRenderer();
        glUgl2.gluBeginCurve(gluNurbs);
        glUgl2.gluNurbsCurve(gluNurbs, heartPoints.length, heartPoints, 3, leftPoints, 4, GL2.GL_MAP1_VERTEX_3);
        glUgl2.gluEndCurve(gluNurbs);

        glUgl2.gluBeginCurve(gluNurbs);
        glUgl2.gluNurbsCurve(gluNurbs, heartPoints.length, heartPoints, 3, rightPoints, 4, GL2.GL_MAP1_VERTEX_3);
        glUgl2.gluEndCurve(gluNurbs);

        gl2.glFlush();
    }

    @Override
    public void reshape(final GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {}
}

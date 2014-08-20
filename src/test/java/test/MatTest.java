package test;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_features2d;
import org.bytedeco.javacpp.opencv_highgui;
import org.bytedeco.javacv.CanvasFrame;
import org.junit.Test;
import topology.Serializable;

/**
 * Created by nurlan on 8/20/14.
 */
public class MatTest {
    @Test
    public void testMat() {
        String SOURCE_FILE = "/home/storm/logo-dect/video/1.mp4";
        //String SOURCE_FILE = "/Users/nurlan/Desktop/1.mp4";
        opencv_highgui.VideoCapture capture = new opencv_highgui.VideoCapture(SOURCE_FILE);

        opencv_core.Mat mat = new opencv_core.Mat();
        //CanvasFrame canvasFrame = new CanvasFrame("first");

        int frameId = 0, firstFrameId = 35000, lastFrameId = 35200;
        while (++frameId < firstFrameId) {
            if (capture.grab())
                ;
            else {
                System.out.println(frameId);
                break;
            }
            if ( (frameId & 0xfff) == 0 )
                System.out.println(frameId);
        }
        while (++frameId < lastFrameId) {
            //System.out.println(frameId);
            capture.read(mat);
            Serializable.Mat sMat = new Serializable.Mat(mat);
            //canvasFrame.showImage(sMat.toJavaCVMat().asIplImage());
        }

        //canvasFrame.dispose();
        mat.release();
        capture.release();
    }
}

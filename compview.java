import org.opencv.core.*;

import java.util.ArrayList;
import org.opencv.imgproc.*;

public class compview {

	// TODO Auto-generated method stub

	/**
	 * @param image
	 *            may be modified
	 * @param edgeContours
	 * @param mat
	 * @param hierarchy
	 * @param mode
	 * @param method
	 * @return
	 */
	static Mat findAndDrawContours(Mat image, ArrayList<MatOfPoint> edgeContours, Mat mat) {
		Mat img = image.clone();
		int contourIdx = -1; // draw all contours
		new Mat();
		Mat blank = Mat.zeros(mat.width(), mat.height(), CvType.CV_16U);
		Point centroid = new Point();

		Scalar color = new Scalar(255, 0, 0);
		Imgproc.drawContours(blank, edgeContours, contourIdx, color, 2);
		Imgproc.fillPoly(blank, edgeContours, color);
		Moments m = Imgproc.moments(blank);
		centroid.x = m.get_m10() / m.get_m00();
		centroid.y = m.get_m01() / m.get_m00();

		Scalar color1 = new Scalar(255, 255, 255);
		Imgproc.circle(img, centroid, 10, color1, 2);
		System.out.println(centroid.x);
		System.out.println(centroid.y);
		return img;
	}

}

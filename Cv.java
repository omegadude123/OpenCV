import java.io.IOException;

import org.opencv.core.*;
import org.opencv.imgcodecs.*;

public class Cv {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		orangeUpipe i = new orangeUpipe();
		for (int q = 1; q < 16; q++) {
			Mat image = Imgcodecs.imread("imgs/JPEG/img (" + q + ").jpg");

			i.setsource0(image);

			i.process();
			System.out.println(i.filterContoursOutput());
			Imgcodecs.imwrite("out(" + q + ").jpg",
					compview.findAndDrawContours(image, i.filterContoursOutput(), i.hsvThresholdOutput()));

		}

		System.out.println();
	}
}

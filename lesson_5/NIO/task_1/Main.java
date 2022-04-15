import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    String [] ext = {"docx","txt"};
		String path_out = "C:\\Users\\User\\Desktop\\test_IO_NIO";
		String path_in = "C:\\Users\\User\\Desktop\\in_test";
		MyFileFilter filefilter = new MyFileFilter(ext);
		File folder = new File(path_out);
		File[] fileList = folder.listFiles(filefilter);
		
		for (File file : fileList) {
			System.out.println(file.getName());
			try (FileInputStream fInput = new FileInputStream(file);
				 FileOutputStream fOut = new FileOutputStream(path_in + "\\" + file.getName()))	{
				byte[] buffer = new byte[1024];
				int byteRead = 0;
				for (;(byteRead = fInput.read(buffer)) >0;) {
					fOut.write(buffer,0,byteRead);
				}
			} catch (IOException e) {D
				e.printStackTrace();
			}
		}
  }
}

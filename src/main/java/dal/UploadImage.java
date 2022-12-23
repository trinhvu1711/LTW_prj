package dal;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;

import jakarta.servlet.http.Part;

public class UploadImage extends DBContext{
	public void upload(Part part) {
		try {
            PreparedStatement ps = connection.prepareStatement("insert into image values(?)");
            InputStream is = part.getInputStream();
            ps.setBlob(1, is);
           
        } catch (Exception e) {
           System.out.println(e);
        }
	}
}

package cn.edu.fjnu.towide.wrapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 参见:http://www.cnblogs.com/jiangxinnju/p/5709378.html
 * @author lenovo
 *
 */
class BufferedServletInputStream extends ServletInputStream {
    private ByteArrayInputStream inputStream;
    public BufferedServletInputStream(byte[] buffer) {
        this.inputStream = new ByteArrayInputStream( buffer );
    }
    @Override
    public int available() throws IOException {
        return inputStream.available();
    }
    @Override
    public int read() throws IOException {
        return inputStream.read();
    }
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read( b, off, len );
    }
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setReadListener(ReadListener listener) {
		// TODO Auto-generated method stub
		
	}
}

public class BufferedServletRequestWrapper extends HttpServletRequestWrapper {
    private byte[] buffer;
    public BufferedServletRequestWrapper(HttpServletRequest request) throws IOException {
        super( request );
        InputStream is = request.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte buff[] = new byte[ 1024 ];
        int read;
        while( ( read = is.read( buff ) ) > 0 ) {
            baos.write( buff, 0, read );
        }
        this.buffer = baos.toByteArray();
    }
    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new BufferedServletInputStream( this.buffer );
    }
}
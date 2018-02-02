package com.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

/**
 * IOUtils
 */
public abstract class IOUtil {
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    /**
     * closeQuietly
     */
    public static void closeQuietly( Closeable closeable ) {
        try {
            if ( closeable != null ) {
                closeable.close();
            }
        } catch ( IOException ioe ) {
            // ignore
        }
    }

    /**
     * InputStream to String
     */
    public static String toString( InputStream input ) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[DEFAULT_BUFFER_SIZE];
        for ( int n; (n = input.read( b )) != -1; ) {
            out.append( new String( b, 0, n ) );
        }
        IOUtil.closeQuietly( input );
        return out.toString();
    }

    /**
     * InputStream to File
     */
    public static void toFile( InputStream input, File file ) throws IOException {
        OutputStream os = new FileOutputStream( file );
        int bytesRead = 0;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        while ( (bytesRead = input.read( buffer, 0, DEFAULT_BUFFER_SIZE )) != -1 ) {
            os.write( buffer, 0, bytesRead );
        }
        IOUtil.closeQuietly( os );
        IOUtil.closeQuietly( input );
    }

    /**
     * 读取资源文件返回流
     */
    public static InputStream readResourceAsStream( HttpServletRequest request, String filePath ) {
        return request.getServletContext().getResourceAsStream( filePath );
    }

    /**
     * 读取资源文件返回字符串
     */
    public static String readResourceAsString( HttpServletRequest request, String filePath ) throws IOException {
        return toString( request.getServletContext().getResourceAsStream( filePath ) );
    }

    /**
     * 读取资源文件URL
     */
    public static URL readResourceAsUrl( HttpServletRequest request, String filePath ) throws MalformedURLException {
        return request.getServletContext().getResource( filePath );
    }

}

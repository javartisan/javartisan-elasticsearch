//package com.javartisan.springboot.javartisanspringboot;
//
//import org.apache.commons.lang3.StringUtils;
//
//import java.io.*;
//import java.nio.charset.Charset;
//
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//
//
//public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
//
//    private final byte[] body;
//
//    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
//        super(request);
//        body = toByteArray(request.getInputStream());
//    }
//
//    private byte[] toByteArray(InputStream in) throws IOException {
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024 * 4];
//        int n = 0;
//        while ((n = in.read(buffer)) != -1) {
//            out.write(buffer, 0, n);
//        }
//        return out.toByteArray();
//    }
//
//    @Override
//    public BufferedReader getReader() throws IOException {
//        return new BufferedReader(new InputStreamReader(getInputStream()));
//    }
//
//
//    @Override
//    public ServletInputStream getInputStream() throws IOException {
//        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
//        return new ServletInputStream() {
//            @Override
//            public boolean isFinished() {
//                return false;
//            }
//
//            @Override
//            public boolean isReady() {
//                return false;
//            }
//
//            @Override
//            public void setReadListener(ReadListener listener) {
//
//            }
//
//            @Override
//            public int read() {
//                return bais.read();
//            }
//        };
//    }
//}
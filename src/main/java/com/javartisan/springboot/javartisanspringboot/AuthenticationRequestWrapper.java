//package com.javartisan.springboot.javartisanspringboot;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.io.*;
//
//public class AuthenticationRequestWrapper extends HttpServletRequestWrapper {
//    private static final Logger logger = LoggerFactory.getLogger(AuthenticationRequestWrapper.class);
//    //post请求参数
//    private final String payload;
//
//    public AuthenticationRequestWrapper(HttpServletRequest request) throws IOException {
//        super(request);
//        // read the original payload into the payload variable
//        StringBuilder stringBuilder = new StringBuilder();
//        BufferedReader bufferedReader = null;
//        InputStream inputStream = null;
//        try {
//            // read the payload into the StringBuilder
//            inputStream = request.getInputStream();
//            if (inputStream != null) {
//                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                char[] charBuffer = new char[128];
//                int bytesRead = -1;
//                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
//                    stringBuilder.append(charBuffer, 0, bytesRead);
//                }
//            } else {
//                // make an empty string since there is no payload
//                stringBuilder.append("");
//            }
//        } catch (IOException ex) {
//            logger.error("Error reading the request payload", ex);
//            throw new IOException("Error reading the request payload", ex);
//        } finally {
//            if (bufferedReader != null) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException iox) {
//                    logger.error("Error close bufferedReader", iox);
//                }
//            }
////            if (inputStream != null) {
////                try {
////                    inputStream.close();
////                } catch (IOException iox) {
////                    logger.error("Error close inputStream", iox);
////                }
////            }
//        }
//        payload = stringBuilder.toString();
//    }
//
//    @Override
//    public ServletInputStream getInputStream() throws IOException {
//        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload.getBytes());
//        ServletInputStream inputStream = new ServletInputStream() {
//            public int read()
//                    throws IOException {
//                return byteArrayInputStream.read();
//            }
//
//            @Override
//            public boolean isFinished() {
//
//                return false;
//            }
//
//            @Override
//            public boolean isReady() {
//
//                return false;
//            }
//
//            @Override
//            public void setReadListener(ReadListener readListener) {
//            }
//        };
//        return inputStream;
//    }
//
//    public String getPayload() {
//        return payload;
//    }
//}
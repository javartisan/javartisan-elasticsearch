package com.javartisan.springboot.javartisanspringboot;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoggerRequestWapper extends HttpServletRequestWrapper {


    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public LoggerRequestWapper(HttpServletRequest request) {
        //异常，此时request在下面已经被读取了，所以创给父类在读取会报错
        super(request);
        ServletInputStream in = null;
        StringBuilder builder = new StringBuilder();
        try {
            in = request.getInputStream();
            byte[] buf = new byte[1024];
            int index = in.read(buf);
            while (index != -1) {
                builder.append(new String(buf, 0, index));
                index = in.read(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            java.io.IOException: Stream closed 这一块不要关闭输入流,关闭流就意味着不可读了，随便你保留了body，但是框架依旧认为是不可读
//            try {
////                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        body = builder.toString();

        System.out.println("body = " + body);

    }

    private String body;

    public String getBody() {
        return body;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() {
                return bais.read();
            }


        };
    }


}

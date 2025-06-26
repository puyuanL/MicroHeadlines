package util;

import common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class WebUtil {
    private static final ObjectMapper objectMapper;
    // Init ObjectMapper
    static{
        objectMapper=new ObjectMapper();
        // set time Convert Format of JSON and Object
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    // get JSON from request and convert to Object
    public static <T> T readJson(HttpServletRequest request,Class<T> clazz){
        T t;
        BufferedReader reader;
        try {
            reader = request.getReader();
            StringBuilder buffer =new StringBuilder();
            String line;
            while((line = reader.readLine())!= null){
                buffer.append(line);
            }

            t= objectMapper.readValue(buffer.toString(),clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
    // Convert Result to JSON, and put Result into response
    public static void writeJson(HttpServletResponse response, Result<?> result){
        response.setContentType("application/json;charset=UTF-8");
        try {
            String json = objectMapper.writeValueAsString(result);
            response.getWriter().write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.pokedex.pokedex.exceptions;
import java.util.List;
import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException{

    private Integer code;
    private HttpStatus httpStatus;
    private List<String> data;

    public APIException(APIError APIError){
        super(APIError.getMessage());
        this.code = APIError.getCode();
        this.httpStatus = APIError.getHttpStatus();
        this.data = APIError.getData();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    

}

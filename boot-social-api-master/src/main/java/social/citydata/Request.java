package social.citydata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Sets;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Set;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    @JsonProperty("agency_name")
    private String name;

    @JsonProperty("address_to_request")
    private String adress;

    @JsonProperty("end_date")
    private String date;

    public Request() {

    }

    public Request(String name, String address, String date) {
        this.name = name;
        this.adress = address;
        this.date = date;
    }

//    public <T> Set<T> toResponseSet(Class<T[]> setType) {
//        HttpEntity<?> body = new HttpEntity<>(objectBody, headers);
//        ResponseEntity<T[]> response = template.exchange(url, method, body, setType);
//        return Sets.newHashSet(response.getBody());
//    }
}

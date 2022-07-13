package json4me;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.odpi.openmetadata.accessservices.datamanager.rest.ConnectionRequestBody;

public class ShowConnection {

     public static void main(String[] args) {
          ConnectionRequestBody connectionRequestBody = new ConnectionRequestBody();

          ObjectMapper objectMapper = new ObjectMapper();

          // set override for null values on the class we want to inspect
          objectMapper.configOverride(ConnectionRequestBody.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.ALWAYS,null));

          // Ok let's create one (could build up a real useful object here for an example if one wishes)
          ConnectionRequestBody crb = new ConnectionRequestBody();

          // And use Jackson to produce the expected JSON
          try {
               String crbAsString = objectMapper.writeValueAsString(crb);
               System.out.println(crbAsString);

          } catch (Exception e) {
               e.printStackTrace();
          }
     }


}

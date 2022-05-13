package odjects.reqres;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String name;
    String job;
    String email;
    String password;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
}

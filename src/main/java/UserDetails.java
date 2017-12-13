import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class UserDetails {
    int id;
    String name;
    FingerprintTemplate template;

    public UserDetails(int id, String name, FingerprintTemplate template) {
        this.id = id;
        this.name = name;
        this.template = template;
    }


}

import com.machinezoo.sourceafis.FingerprintTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main() throws Exception {
        byte[] probeImage = Files.readAllBytes(Paths.get("probe.jpeg"));
        byte[] candidateImage = Files.readAllBytes(Paths.get("candidate.jpeg"));
        FingerprintTemplate probe = new FingerprintTemplate(probeImage);
        FingerprintTemplate candidate = new FingerprintTemplate(candidateImage);





    }
}

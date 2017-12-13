import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;

//https://sourceafis.machinezoo.com/

public class Main {

    public static void main(String[] args) throws Exception {

        double threshold = 40; //FMR 0.01%

        byte[] probeImage = Files.readAllBytes(Paths.get("db/101_1.jpg"));
        byte[] candidateImage = Files.readAllBytes(Paths.get("db/101_2.jpg"));
        byte[] candidateImage2 = Files.readAllBytes(Paths.get("db/101_3.jpg"));
        FingerprintTemplate probe = new FingerprintTemplate(probeImage);
        FingerprintTemplate candidate = new FingerprintTemplate(candidateImage);
        FingerprintTemplate candidate2 = new FingerprintTemplate(candidateImage2);

        System.out.println("-----START-----");

        FingerprintMatcher matcher = new FingerprintMatcher(probe);
        double score = matcher.match(candidate);
        double score2 = matcher.match(candidate2);
        System.out.println(String.format("Match with score: %f => Results: %s", score, score >= threshold));
        System.out.println(String.format("Match with score: %f => Results: %s", score2, score2 >= threshold));


        System.out.println("-----END-----");
    }
}

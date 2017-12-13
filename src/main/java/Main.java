import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//https://sourceafis.machinezoo.com/

public class Main {

    public static void matching1to1() throws Exception {
        double threshold = 40; //FMR 0.01%
        System.out.println("-----START 1:1 matching-----");
        byte[] probeImage = Files.readAllBytes(Paths.get("db/102_1.jpg"));
        byte[] candidateImage = Files.readAllBytes(Paths.get("db/102_2.jpg"));
        byte[] candidateImage2 = Files.readAllBytes(Paths.get("db/101_1.jpg"));
        FingerprintTemplate probe = new FingerprintTemplate(probeImage);
        FingerprintTemplate candidate = new FingerprintTemplate(candidateImage);
        FingerprintTemplate candidate2 = new FingerprintTemplate(candidateImage2);

        FingerprintMatcher matcher = new FingerprintMatcher(probe);

        long start = System.currentTimeMillis();
        double score = matcher.match(candidate);
        System.out.println(String.format("Match with score: %f => Results: %s in %dms", score, score >= threshold, (System.currentTimeMillis() - start)));

        double score2 = matcher.match(candidate2);
        System.out.println(String.format("Match with score: %f => Results: %s in %dms", score2, score2 >= threshold, (System.currentTimeMillis() - start)));
        System.out.println("-----END 1:1 matching-----");

    }

    public static UserDetails findInN(FingerprintTemplate probe, Iterable<UserDetails> candidates) {
        FingerprintMatcher matcher = new FingerprintMatcher(probe);
        UserDetails match = null;
        double high = 0;
        for (UserDetails candidate : candidates) {
            double score = matcher.match(candidate.template);
            if (score > high) {
                high = score;
                match = candidate;
            }
            System.out.println("math " + candidate.id + " with score: " + score);
        }
        double threshold = 40;
        return high >= threshold ? match : null;
    }

    public static void matching1toN() throws Exception {
        System.out.println("-----START 1:N matching-----");

        FingerprintTemplate probe = new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_1.jpg")));

        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(new UserDetails(2, "101_2", new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_2.jpg")))));
        userDetailsList.add(new UserDetails(3, "101_3", new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_3.jpg")))));
        userDetailsList.add(new UserDetails(4, "101_4", new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_4.jpg")))));
        userDetailsList.add(new UserDetails(5, "101_5", new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_5.jpg")))));
        userDetailsList.add(new UserDetails(6, "101_6", new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_6.jpg")))));
        userDetailsList.add(new UserDetails(7, "101_7", new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_7.jpg")))));
        userDetailsList.add(new UserDetails(8, "101_8", new FingerprintTemplate(Files.readAllBytes(Paths.get("db/101_8.jpg")))));

        long start = System.currentTimeMillis();
        UserDetails match = findInN(probe, userDetailsList);
        System.out.println("Result: " + (match == null ? "Not found" : match.name));

        System.out.println("-----END 1:N matching in " + (System.currentTimeMillis() - start) + "ms -----");
    }

    public static void main(String[] args) throws Exception {

        matching1to1();
        matching1toN();

    }
}

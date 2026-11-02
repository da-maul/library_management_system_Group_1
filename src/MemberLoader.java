import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MemberLoader {
    private final String delimiter = ",";

    public List<Member> loadMembers(String filename) throws IOException {
        Path path = Path.of(filename);
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);
                members.add(new Member(fields[1], Integer.parseInt(fields[0])));
            }
        }
        return members;
    }
}

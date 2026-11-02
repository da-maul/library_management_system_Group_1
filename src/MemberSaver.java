import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class MemberSaver {
    private final String delimiter = ",";

    public void saveMembers(List<Member> members, String filename) throws IOException{
    Path path = Path.of(filename);
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
        for (Member member : members) {
            writer.write(member.ID() + delimiter + member.name());
            writer.newLine();
        }
    }
  }
}

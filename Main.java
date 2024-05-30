import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/sendilien/d/Media/Wallpaper");

        Set<String> filenames = new HashSet<>();

        try (Stream<Path> list = Files.list(dir)) {
            filenames = list
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(filename -> filename.endsWith(".jpg"))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(filenames);

        try {
            Path copy = Paths.get("/home/sendilien/d/Media/Wallpaper/copy");
            Files.createDirectories(copy);

            System.out.println("A file directory created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        for (String filename : filenames) {
            try {
                Files.copy(Path.of("/home/sendilien/d/Media/Wallpaper/" + filename), Path.of("/home/sendilien/d/Media/Wallpaper/copy/" + filename), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHelper {

    public static List<Path> listAllInDirectory(File dir, final String fileExtension){
        try(Stream<Path> fileStream = Files.find(Paths.get(dir.getPath()), 5, (p, bfa) -> bfa.isRegularFile())){
            return fileStream
                    .filter(path -> path.toString().endsWith(fileExtension))
                    .collect(Collectors.toCollection(ArrayList::new));
        }catch (IOException ex){
            throw new RuntimeException(String.format("List file in directory: %s failed, Error: %s ",dir.getPath(),ex.getMessage()));
        }
    }
}

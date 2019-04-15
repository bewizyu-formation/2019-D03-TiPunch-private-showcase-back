package fr.formation.image;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import fr.formation.artist.ArtistRepository;
import fr.formation.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;

@Service
public class ImageStorageService {

    private final Path rootLocation = Paths.get(ConstantPath.UPLOAD_LOCATION);
    List<String> files = new ArrayList<String>();
    @Autowired
    private ArtistRepository artistRepository;

    /**
     * Save image
     * @param file
     */
    public void store(MultipartFile file) {

        try {

            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file ");
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!" );
        }
    }

    /**
     * Load image
     * @param filename
     * @return
     */
    public Resource loadImage(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read file!" + filename );
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void getDefaultPicture(Artist artist){
        File file = new File("image/default.png");
        byte[] defaultPicture = new byte[(int) file.length()];
        artistRepository.findArtistById(artist.getId()).setImage(defaultPicture);

    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @PostConstruct
    public void init() {
        try {
            deleteAll();
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }




}

package fr.formation.image;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import fr.formation.artist.ArtistRepository;
import fr.formation.modelDto.ArtistDto;
import fr.formation.models.Artist;
import fr.formation.user.UserService;
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

    private ArtistRepository artistRepository;

    public ImageStorageService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    /**
     * Save image
     * @param file
     */
    public byte[] store(String pictureName, MultipartFile file, Artist artist) {

        byte[] picture;

        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file ");
            }else {
                picture = file.getBytes();
                artist.setImage(picture);
                artistRepository.save(artist);
            }

        } catch (Exception e) { throw new RuntimeException("FAIL!" ); }

        return picture;
    }


    /**
     * default image
     * @return byte
     */
    public byte[] getDefaultPicture(){

        File file = new File("image/default.png");
        byte[] defaultPicture = new byte[(int) file.length()];

        try {

            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(defaultPicture);
            fileInputStream.close();

        } catch (Exception e) { e.printStackTrace(); }

         return defaultPicture;
    }

    /**
     * load image
     * @param artist
     * @return byte
     */
    public byte[] loadImage(Artist artist){
        byte[] picture = artist.getImage();
        return picture;
    }

}

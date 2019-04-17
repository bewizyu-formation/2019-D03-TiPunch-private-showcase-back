package fr.formation.image;

import java.io.*;

import fr.formation.artist.ArtistRepository;
import fr.formation.models.Artist;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


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

        File file = new File("image/default.jpg");
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

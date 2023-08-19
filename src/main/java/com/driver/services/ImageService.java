package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image(blog,description,dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=imageRepository2.findById(id).get();
        String imageDimensions= image.getDimensions();

        String[] imagearr =imageDimensions.split("X");
        String[] screenarr =screenDimensions.split("X");

        int imageWidth=Integer.parseInt(imagearr[0]);
        int imageHeight=Integer.parseInt(imagearr[1]);

        int screenWidth=Integer.parseInt(screenarr[0]);
        int screenHeight=Integer.parseInt(screenarr[1]);
        return NoOfImagesPossible(imageWidth,imageHeight,screenWidth,screenHeight);
    }

    private int NoOfImagesPossible(int imageWidth, int imageHeight, int screenWidth, int screenHeight) {
        int width=screenWidth/imageWidth;
        int height=screenHeight/imageHeight;
        return width*height;
    }
}

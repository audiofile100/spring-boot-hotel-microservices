package com.synergisticit.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.synergisticit.domain.Amenities;
import com.synergisticit.domain.Hotel;
import com.synergisticit.domain.RoomType;
import com.synergisticit.domain.User;
import com.synergisticit.service.AmenitiesService;
import com.synergisticit.service.HotelService;
import com.synergisticit.service.RoomTypeService;
import com.synergisticit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Component
public class CommanLineRunnerImpl implements CommandLineRunner {

    private final ResourceLoader resourceLoader;
    private final HotelService hotelService;
    private final AmenitiesService amenitiesService;
    private final RoomTypeService roomTypeService;
    private final UserService userService;

    public CommanLineRunnerImpl(ResourceLoader resourceLoader,
                                HotelService hotelService,
                                AmenitiesService amenitiesService,
                                RoomTypeService roomTypeService,
                                UserService userService) {
        this.resourceLoader = resourceLoader;
        this.hotelService = hotelService;
        this.amenitiesService = amenitiesService;
        this.roomTypeService = roomTypeService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData("classpath:static/json/users.json", "users");
        loadData("classpath:static/json/roomtype.json", "roomtype");
        loadData("classpath:static/json/amenities.json", "amenities");
        loadData("classpath:static/json/hotels.json", "hotel");
    }

    private void loadData(String path, String entity) throws Exception {

        Resource resource = resourceLoader.getResource(path);
        InputStream inputStream = resource.getInputStream();

        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);

            GsonBuilder gsonBuilder = null;
            Gson gson = null;
            Type listType = null;

            switch (entity) {
                case "users":
                    gson = new Gson();
                    listType = new TypeToken<List<User>>() {}.getType();
                    List<User> users = gson.fromJson(data, listType);

                    for (User u : users)
                        userService.save(u);
                    break;

                case "roomtype":
                    gson = new Gson();
                    listType = new TypeToken<List<RoomType>>() {}.getType();
                    List<RoomType> roomTypes = gson.fromJson(data, listType);

                    for (RoomType rt : roomTypes)
                        roomTypeService.save(rt);
                    break;

                case "amenities":
                    gson = new Gson();
                    listType = new TypeToken<List<Amenities>>() {}.getType();
                    List<Amenities> amenities = gson.fromJson(data, listType);

                    for (Amenities a : amenities) {
                        amenitiesService.save(a);
                    }
                    break;

                case "hotel":
                    gson = new Gson();
                    listType = new TypeToken<List<Hotel>>() {}.getType();
                    List<Hotel> hotels = gson.fromJson(data, listType);

                    for (Hotel h : hotels) {
                        hotelService.save(h);
                    }
                    break;
            }

        } catch (IOException e) {
            log.error("IOException", e);
        }
    }
}

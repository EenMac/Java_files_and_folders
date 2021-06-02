package com.codeclan.EenMac.files_and_folders.components;


import com.codeclan.EenMac.files_and_folders.models.File;
import com.codeclan.EenMac.files_and_folders.models.Folder;
import com.codeclan.EenMac.files_and_folders.models.User;
import com.codeclan.EenMac.files_and_folders.repositories.FileRepository;
import com.codeclan.EenMac.files_and_folders.repositories.FolderRepository;
import com.codeclan.EenMac.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Folder music = new Folder("music");
        folderRepository.save(music);

        Folder games = new Folder("games");
        folderRepository.save(games);

        Folder apps = new Folder("applications");
        folderRepository.save(apps);

        File song1 = new File("Don't stop", ".mp4", 65, music);
        fileRepository.save(song1);

        File song2 = new File("having fun", ".mp4", 63, music);
        fileRepository.save(song2);

        File game1 = new File("scrabble",".exe", 2000, games);
        fileRepository.save(game1);

        File app1 = new File("Shazam", ".exe", 1000, apps);
        fileRepository.save(app1);

        User john = new User("John");
        userRepository.save(john);

        User stephanie = new User("Stephanie");
        userRepository.save(stephanie);

        games.addFile(game1);
        folderRepository.save(games);

        music.addFile(song1);
        music.addFile(song2);
        folderRepository.save(music);

        apps.addFile(app1);
        folderRepository.save(apps);

        john.addFolder(games);
        john.addFolder(music);
        john.addFolder(apps);
        userRepository.save(john);

        stephanie.addFolder(games);
        stephanie.addFolder(music);
        stephanie.addFolder(apps);
        userRepository.save(stephanie);

    }
}

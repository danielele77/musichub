import os
import string
import re


def remove_special_characters(song_name: string):
    pattern1 = re.compile(r'[\[(].*?[])]')
    pattern2 = re.compile(r'[,_-]')
    new_song_name = pattern1.sub('', song_name)
    new_song_name = pattern2.sub('', new_song_name)
    return new_song_name


def rename_file(file_path, new_name):
    if not os.path.exists(new_name):
        os.rename(file_path, new_name)
        return

    base_name, extension = os.path.splitext(new_name)
    counter = 1
    while os.path.exists(f"{base_name}{counter}{extension}"):
        counter += 1

    os.rename(file_path, f"{base_name}{counter}{extension}")
    # print(f"{base_name}{counter}{extension}")


if __name__ == '__main__':
    # Change path to the specific folder
    basePath = "C:/Users/user/Downloads/MusicHub"

    folders = os.listdir(basePath)

    for genre in folders:
        genre_path = basePath + "/" + genre
        songs = os.listdir(genre_path)
        for song in songs:
            new_name = song.replace(" ", "")
            new_name = remove_special_characters(new_name)
            rename_file(genre_path + "/" + song, genre_path + "/" + new_name)

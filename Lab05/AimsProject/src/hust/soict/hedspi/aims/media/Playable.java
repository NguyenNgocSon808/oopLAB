package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException; // Import PlayerException

public interface Playable {
    void play() throws PlayerException;
}
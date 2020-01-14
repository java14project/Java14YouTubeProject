package threads;

import responses.Thumbnails;

public class ThumbnailsThread extends Thread{

    private Thumbnails thumbnails;

    public ThumbnailsThread(Thumbnails thumbnails) {
        super("Thumbnails thread");
        this.thumbnails = thumbnails;
    }

    @Override
    public void run() {
        super.run();
    }

    public Thumbnails getThumbnails(){
        return thumbnails;
    }
}

package dk.kea.class2019.tsbat.gameengine19;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public class Music implements MediaPlayer.OnCompletionListener
{

    private MediaPlayer mediaPlayer; //It's boombox!
    private boolean isPrepared = false; // is the MediaPlayer rdy?

    public Music(AssetFileDescriptor assetFileDescriptor)
    {
        mediaPlayer = new MediaPlayer();
        try
        {
            // The file will play from beggingn(StartOffSet) to the end(getLength());
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            isPrepared = true;
            mediaPlayer.setOnCompletionListener(this);
        }
        catch(IOException e)
        {
            throw new RuntimeException("Could not open a music fileDescriptor: " + assetFileDescriptor);
        }
    }

    public void iispose()
    {
        if (mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    public boolean isLooping()
    {
        return mediaPlayer.isPlaying();
    }

    public boolean isPlaying()
    {
        return mediaPlayer.isPlaying();
    }

    public boolean isStopped()
    {
        return !isPrepared;
    }

    public void pause()
    {
        if (mediaPlayer.isPlaying()) mediaPlayer.pause();
    }

    public void play()
    {
        if (mediaPlayer.isPlaying()) return;
        try
        {
            synchronized(this)
            {
                if(!isPrepared) mediaPlayer.prepare();
                mediaPlayer.start();
            }

        }
        catch(IllegalStateException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Music class: You are trying to lay from a wrong MediaPlayer");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            throw new RuntimeException(("MediaPlayer play error."));
        }
    }

    public void setLooping(boolean loop)
    {
        mediaPlayer.setLooping(loop);
    }

    public void setVolume(float volume)
    {
        mediaPlayer.setVolume(volume, volume); //Left and Write channel
    }

    public void stop()
    {
        synchronized (this)
        {
            if (!isPrepared) return;
            mediaPlayer.stop();
            isPrepared = false;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        synchronized (this)
        {
            isPrepared = false;
        }
    }
}

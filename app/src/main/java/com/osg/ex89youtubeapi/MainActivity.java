package com.osg.ex89youtubeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends AppCompatActivity {

    //YouTubePlayerView는 반드시 YouTubeBaseActivity 안에서만 보여짐
    //but...YouTubeBaseActivity는 .androidx.를 상속받지 않고! 그냥 Activity만 상속받음 -> androidx와 관련된 모든 것 사용 불가...
    //ex. getSupport...로 시작하는거 전부 사용 못함!
    YouTubePlayerView youTubePlayerView;

    //그래서..이거 대신에 쓸 것 -> YouTubePlayerFragment

    YouTubePlayerFragment youTubePlayerFragment; //프레그먼트가 플레이어뷰를 제어하기 때문에 액티비티를 바꾸지 않아도 된다,
    YouTubePlayerFragment youTubePlayerFragment2;

    YouTubeThumbnailView thumbnailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        youTubePlayerView = findViewById(R.id.youtubeView);
//        youTubePlayerView.initialize("first", new YouTubePlayer.OnInitializedListener()  {//동영상 넣기 전에 초기화 먼저 해야함 (뷰의 이름, 리스너)
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.cueVideo("9K7t0o7Kqcs"); //유튜브의 동영상 ID 넣기기 (영상창 주소에서 v=의 파라미터값!)
//           }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {}
//        });

        youTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtube_frag); //유튜브 프레그먼트는 여전히  SupportFragmentManager 사용 불가능함..
        youTubePlayerFragment.initialize("video", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("VqkUcD4VngU");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        youTubePlayerFragment2 = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtube_frag2); //유튜브 프레그먼트는 여전히  SupportFragmentManager 사용 불가능함..
        youTubePlayerFragment2.initialize("video2", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("vf8t8LgZj74"); //얘는 로딩 끝나면 자동재생됨
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


        thumbnailView = findViewById(R.id.thumbView);
        thumbnailView.initialize("thumb", new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo("Eyvnxxq0YhU");
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


    }


    public void clickBtntn(View view) {
        Intent intent = new Intent(this, YoutubeDataActivity.class);
        startActivity(intent);
    }
}
package com.lightningboys.uhchinseo.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Music_Stage_Game")
@Getter @Setter
public class MusicStageGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_stage_id")
    private Long id;

    @Column(name="music_stage_image_id")
    private int musicStageImage;

    @Column(name="music_stage_singer")
    private String singer;

    @Column(name="music_stage_music")
    private String music;

    @Column(name="music_stage_answer")
    private Character answer;

}

package io.github.kuri_megane;

import io.github.kuri_megane.Layer.EndRoll;
import io.github.kuri_megane.Layer.StartMenu;

public class Main {
    public static void main(String[] args) {

        GamaData gamaData = new GamaData();

        // スタートメニューの表示
        StartMenu startMenu = new StartMenu();
        startMenu.display("");
        String name = startMenu.inputName();
        gamaData.setName(name);

        // 1ゲーム目
        Game game = new Game();
        game.run();
        int score = game.getScoreOfThisGame();
        gamaData.setScore(score + gamaData.getScore());

        // エンドロール
        EndRoll endRoll = new EndRoll();
        endRoll.createPlayerResult(gamaData);
        endRoll.display("");

        // 終了
        // XXX: スレッドがうまく終了できていないため
        System.exit(0);
    }
}

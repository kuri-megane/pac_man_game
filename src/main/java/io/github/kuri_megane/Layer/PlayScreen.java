package io.github.kuri_megane.Layer;

import jline.Terminal;
import jline.TerminalFactory;
import jline.console.ConsoleReader;

import java.io.IOException;

public class PlayScreen extends Thread implements BackLayer {

    private int consoleHeight = 0;
    private int consoleWidth = 0;
    private ConsoleReader console;

    public PlayScreen() {

        try {
            console = new ConsoleReader();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


    /**
     * コンソールサイズを取得します．
     */
    public void getConsoleSize() {
        Terminal terminal = TerminalFactory.get();
        consoleHeight = terminal.getHeight();
        consoleWidth = terminal.getWidth();
    }

    /**
     * [テスト用] 取得したコンソールサイズの高さの値を取り出します.
     *
     * @return コンソールサイズの高さ
     */
    public int getConsoleHeight() {
        return consoleHeight;
    }

    /**
     * [テスト用] 取得したコンソールサイズの幅の値を取り出します.
     *
     * @return コンソールサイズの幅
     */
    public int getConsoleWidth() {
        return consoleWidth;
    }

    /**
     * ゲームのプレイ画面 (つまり ゲームマップ) の描画
     *
     * @param strings 描画する文字列
     */
    public void display(String strings) {

        // 表示
        System.out.printf(strings);

        // 一時スリープ
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // クリア
        try {
            console.clearScreen();
            console.flush();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}

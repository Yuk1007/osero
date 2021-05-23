import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;


public class MyClient extends JFrame implements MouseListener, MouseMotionListener
{
    private JButton[][] buttonArray;//ボタン用の配列
    private JButton startButton;
    private int myColor;
    private Container c;
    private ImageIcon sunIcon, rainIcon, boardIcon, tipIcon;
    private PrintWriter out;//出力用のライター
    private ImageIcon myIcon, yourIcon;
    private int myTurn;
    //    private Icon CIcon;
    private String myMove;
    private JLabel theLabel1;
    private JLabel labelTime;
    private Mytimer mt;
    private int keepminute = -1;
    private int keepsecond = -1;
    private int rIcon = 0;
    private int sIcon = 0;
    private JButton theButtonSoundStart1;
    SoundPlayer theSoundPlayer1;
    JButton theButtonSoundStop;
    JTextField tfKeyin;//メッセージ入力用テキストフィールド
    JTextArea taMain;//テキストエリア
    JButton bs = new JButton("Send");
    String myName;
    JButton typhoonButton;
    private int typhooncount = 1;
    private int startcount = 1;
    private JLabel sunLabel;
    private JLabel rainLabel;
    private JLabel sunCountLabel;
    private JLabel rainCountLabel;
    private JLabel enemyLabeltime;
    private JLabel enemyTurn;

    public MyClient()
    {
        //名前の入力ダイアログを開く、ダイアログを消してもゲームが実行される
        myName = JOptionPane.showInputDialog(null , "名前を入力してください" , "名前の入力" , JOptionPane.QUESTION_MESSAGE);
        String myAddr = JOptionPane.showInputDialog(null , "IPアドレスを入力してください" , "名前の入力" , JOptionPane.QUESTION_MESSAGE);
        try
        {
            if (myName.equals(""))
            {
                myName = "unknown";//名前がないときは，"unknown"とする
            }
            else
            {
                throw new NullPointerException();
            }

            if (myAddr.equals(""))
            {
                try
                {
                    InetAddress address = InetAddress.getLocalHost();
                    String localhost = address.getHostAddress();
                    myAddr = localhost;
                    // System.out.println("localhost");
                }
                catch (UnknownHostException e)
                {

                }
            }
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        //ウィンドウを作成する
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ウィンドウを閉じるときに，正しく閉じるように設定する
        setTitle("MyClient");//ウィンドウのタイトルを設定する
        setSize(1000 , 750);//ウィンドウのサイズを設定する
        setLocationRelativeTo(null); // 画面中央に表示
        c = getContentPane();//フレームのペインを取得する

        //アイコンの設定
        rainIcon = new ImageIcon("rain.png");
        sunIcon = new ImageIcon("sun.png");
        boardIcon = new ImageIcon("skyboard.png");
        tipIcon = new ImageIcon("tipIcon2.png");

        c.setLayout(null);//自動レイアウトの設定を行わない
        //ボタンの生成
        buttonArray = new JButton[8][8];
        int k = 0;
        for (int j = 0; j < 8; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                k = j * 8 + i;
                buttonArray[i][j] = new JButton(boardIcon);//ボタンにアイコンを設定する
                c.add(buttonArray[i][j]);//ペインに貼り付ける
                buttonArray[i][j].setBounds(i * 70 , j * 70 , 70 , 70);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
                buttonArray[i][j].addMouseListener(this);//ボタンをマウスでさわったときに反応するようにする
                buttonArray[i][j].addMouseMotionListener(this);//ボタンをマウスで動かそうとしたときに反応するようにする
                buttonArray[i][j].setActionCommand(Integer.toString(k));//ボタンに配列の情報を付加する（ネットワークを介してオブジェクトを識別するため）
            }
        }

        // ラベル作成
        theLabel1 = new JLabel();
        c.add(theLabel1);
        theLabel1.setBounds(590 , 30 , 400 , 100);
        theLabel1.setForeground(Color.BLACK); //文字色の設定．Colorの設定は，このページを見て下さい　http://www.javadrive.jp/tutorial/color
        theLabel1.setFont(new Font("MS　ゴシック" , Font.PLAIN , 50));

        //アイコンの表示
        sunLabel = new JLabel();
        c.add(sunLabel);
        sunLabel.setBounds(750 , 100 , 200 , 100);
        sunLabel.setForeground(Color.BLACK); //文字色の設定．Colorの設定は，このページを見て下さい　http://www.javadrive.jp/tutorial/color
        sunLabel.setFont(new Font("MS　ゴシック" , Font.PLAIN , 50));

        rainLabel = new JLabel();
        c.add(rainLabel);
        rainLabel.setBounds(750 , 100 , 200 , 100);
        rainLabel.setForeground(Color.BLACK); //文字色の設定．Colorの設定は，このページを見て下さい　http://www.javadrive.jp/tutorial/color
        rainLabel.setFont(new Font("MS　ゴシック" , Font.PLAIN , 50));

        //枚数の表示
        sunCountLabel = new JLabel();
        c.add(sunCountLabel);
        sunCountLabel.setBounds(800 , 600 , 200 , 100);
        sunCountLabel.setForeground(Color.BLACK);
        sunCountLabel.setFont(new Font("MS　ゴシック" , Font.PLAIN , 40));

        rainCountLabel = new JLabel();
        c.add(rainCountLabel);
        rainCountLabel.setBounds(830 , 530 , 150 , 100);
        rainCountLabel.setForeground(Color.BLACK);
        rainCountLabel.setFont(new Font("MS　ゴシック" , Font.PLAIN , 40));

        //相手の時間表示
        enemyLabeltime = new JLabel();
        c.add(enemyLabeltime);
        enemyLabeltime.setBounds(630 , 590 , 200 , 100);
        enemyLabeltime.setForeground(Color.BLACK);
        enemyLabeltime.setFont(new Font("MS　ゴシック" , Font.PLAIN , 50));

        //相手のターンであることを表示
        enemyTurn = new JLabel();
        c.add(enemyTurn);
        enemyTurn.setBounds(600 , 530 , 200 , 100);
        enemyTurn.setForeground(Color.BLACK);
        enemyTurn.setFont(new Font("MS　ゴシック" , Font.PLAIN , 40));
        enemyTurn.setText("相手の時間");

        //持ち時間表示
        labelTime = new JLabel();
        c.add(labelTime);
        labelTime.setBounds(590 , 100 , 300 , 100);
        labelTime.setForeground(Color.BLACK); //文字色の設定．Colorの設定は，このページを見て下さい　http://www.javadrive.jp/tutorial/color
        labelTime.setFont(new Font("MS　ゴシック" , Font.PLAIN , 50));

        //チャット機能
        tfKeyin = new JTextField("" , 42);//入力用のテキストフィールドを作成
        c.add(tfKeyin);//コンテナに追加
        c.add(bs);//ボタンをコンテナに追加
        bs.setActionCommand("80");//ボタンを押したときの動作するようにする
        tfKeyin.setBounds(590 , 500 , 220 , 30);
        taMain = new JTextArea();//チャットの出力用のフィールドを作成
        JScrollPane theScrollPane = new JScrollPane(taMain , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        c.add(theScrollPane);//コンテナに追加
        theScrollPane.setBounds(590 , 320 , 290 , 180);
        bs.setBounds(810 , 500 , 70 , 30);
        taMain.setEditable(false);//編集不可にする
        bs.addMouseListener(this);

        //開始を合わせるボタン
        ImageIcon start = new ImageIcon("start.png");
        startButton = new JButton(start);
        c.add(startButton);
        startButton.setBounds(590 , 200 , 150 , 50);
        startButton.setActionCommand("64");
        startButton.addMouseListener(this);

        labelTime.setText("10" + ":" + "0" + "0");

        enemyLabeltime.setText("10" + ":" + "0" + "0");

        buttonArray[3][3].setIcon(sunIcon);
        buttonArray[4][4].setIcon(sunIcon);
        buttonArray[4][3].setIcon(rainIcon);
        buttonArray[3][4].setIcon(rainIcon);

        //BGMの再生
        ImageIcon sound = new ImageIcon("sound.png");
        theButtonSoundStart1 = new JButton(sound);//ボタンを作成，テキストの表示
        c.add(theButtonSoundStart1);//ペインに貼り付ける
        theButtonSoundStart1.setBounds(590 , 280 , 100 , 30);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
        theButtonSoundStart1.setActionCommand("65");
        theButtonSoundStart1.addMouseListener(this);

        //BGMの停止
        ImageIcon soundstop = new ImageIcon("soundstop.png");
        theButtonSoundStop = new JButton(soundstop);//ボタンを作成，テキストの表示
        c.add(theButtonSoundStop);//ペインに貼り付ける
        theButtonSoundStop.setBounds(700 , 280 , 100 , 30);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
        theButtonSoundStop.setActionCommand("66");
        theButtonSoundStop.addMouseListener(this);

        //台風を起こすボタン
        ImageIcon typhoonIcon = new ImageIcon("typhoon.png");
        typhoonButton = new JButton(typhoonIcon);
        c.add(typhoonButton);
        typhoonButton.setBounds(800 , 200 , 70 , 70);
        typhoonButton.setActionCommand("67");
        typhoonButton.addMouseListener(this);

        //背景
        ImageIcon icon3 = new ImageIcon("back2.jpg");//なにか画像ファイルをダウンロードしておく
        JLabel theLabel4 = new JLabel(icon3);
        c.add(theLabel4);
        theLabel4.setBounds(0 , 0 , 1000 , 750);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
        theLabel4.addMouseListener(this);//ボタンをマウスでさわったときに反応するようにする
        theLabel4.setForeground(Color.WHITE); //文字色の設定．Colorの設定は，このページを見て下さい　http://www.javadrive.jp/tutorial/color/

        //サーバに接続する
        Socket socket = null;
        try
        {
            //"localhost"は，自分内部への接続．localhostを接続先のIP Address（"133.42.155.201"形式）に設定すると他のPCのサーバと通信できる
            //10000はポート番号．IP Addressで接続するPCを決めて，ポート番号でそのPC上動作するプログラムを特定する
            socket = new Socket(myAddr , 10000);
        }
        catch (UnknownHostException e)
        {
            System.err.println("ホストの IP アドレスが判定できません: " + e);
        }
        catch (IOException e)
        {
            System.err.println("エラーが発生しました: " + e);
        }

        MesgRecvThread mrt = new MesgRecvThread(socket , myName);//受信用のスレッドを作成する

        mrt.start();//スレッドを動かす（Runが動く）
    }

    //持ち時間のスレッド
    public class Mytimer extends Thread
    {
        public int lapminute;
        public int lapsecond;
        public boolean running;

        public Mytimer(int a , int b)
        {
            lapminute = a;
            lapsecond = b;
            running = true;
        }


        public void run()
        {

            for (int i = lapminute; 0 <= i; i--)
            {
                keepminute = i;
                String minute = String.valueOf(keepminute);
                if (keepsecond == 0) lapsecond = 59;
                for (int j = lapsecond; 0 <= j; j--)
                {
                    keepsecond = j;
                    String second = String.valueOf(keepsecond);
                    try
                    {//Thread.sleepはTry-catchでないとつかえないため
                        Thread.sleep(1000); //1000ミリ秒Sleepする
                    }
                    catch (InterruptedException ignored)
                    {

                    }//エラーがでてもなにもしない

                    if (j <= 9)
                    {
                        labelTime.setText("0" + minute + ":" + "0" + second);
                    }
                    else
                    {
                        labelTime.setText("0" + minute + ":" + second);
                    }

                    String timemsg = "ENEMYTIME" + " " + minute + " " + second + " " + myColor;
                    out.println(timemsg);
                    out.flush();
                    repaint();

                    if (!running) break; // running flag がfalseになったら　breakする
                }


                if (!running) break; // running flag がfalseになったら　breakする
            }

            if (keepsecond == 0 && keepminute == 0)
            {
                String msgtimeout = "TIMEOUT";
                out.println(msgtimeout);//送信データをバッファに書き出す
                out.flush();//送信データをフラッシュ（ネットワーク上にはき出す）する
                repaint();//画面のオブジェクトを描画し直す
            }
        }

    }


    // メッセージ受信のためのスレッド
    public class MesgRecvThread extends Thread
    {

        Socket socket;
        String myName;

        public MesgRecvThread(Socket s , String n)
        {
            socket = s;
            myName = n;
        }

        //通信状況を監視し，受信データによって動作する
        public void run()
        {
            try
            {
                InputStreamReader sisr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(sisr);
                out = new PrintWriter(socket.getOutputStream() , true);
                out.println(myName);//接続の最初に名前を送る
                String myNumberStr = br.readLine();
                int myNumberInt = Integer.parseInt(myNumberStr);
                // System.out.println("myNumberStrの中身は" + myNumberStr);
                if (myNumberInt % 2 == 0)
                {
                    myColor = 0;
                    myTurn = myColor;
                    myIcon = sunIcon;
                    yourIcon = rainIcon;
                    myMove = "相手のターン";
                }
                else
                {
                    myColor = 1;
                    myTurn = myColor;
                    myIcon = rainIcon;
                    yourIcon = sunIcon;
                    myMove = "私のターン";
                }

                //自分のターンと枚数の表示
                theLabel1.setText(myMove);
                rainCountLabel.setText("雨" + "：" + 0);
                sunCountLabel.setText("太陽" + "：" + 0);

//               自分のアイコン表示
                if (myColor == 1)
                {
                    rainLabel.setText("雨");
                }
                else
                {
                    sunLabel.setText("太陽");
                }

                if (myTurn == 1) tips();
                System.out.println("探索処理が終わりました。");

                if (myTurn == 0) taMain.append("STARTボタンを押すとゲームが始まります。" + "\n");

                int sss = sunCount();
                String SSS = String.valueOf(sss);
                sunCountLabel.setText("太陽" + "：" + SSS);

                int rrr = rainCount();
                String RRR = String.valueOf(rrr);
                rainCountLabel.setText("雨" + "：" + RRR);


                while (true)
                {
                    String inputLine = br.readLine();//データを一行分だけ読み込んでみる
                    if (inputLine != null)
                    {
                        //読み込んだときにデータが読み込まれたかどうかをチェックする
                        System.out.println(inputLine);//デバッグ（動作確認用）にコンソールに出力する
                        String[] inputTokens = inputLine.split(" ");    //入力データを解析するために、スペースで切り分ける
                        String cmd = inputTokens[0];//コマンドの取り出し．１つ目の要素を取り出す
                        if (cmd.equals("PLACE"))
                        {
                            String XthePName = inputTokens[1];
                            String YthePName = inputTokens[2];
                            int XthePnum = Integer.parseInt(XthePName);
                            int YthePnum = Integer.parseInt(YthePName);
                            int theColor = Integer.parseInt(inputTokens[3]);
                            // System.out.println("XthePName"+ XthePName + "YthePName"+ YthePName );
                            // 自分の時間止めて、相手の時間を動かす
                            if (myTurn == 1)
                            {
                                mt.running = false; // 止める処理
                                mt = new Mytimer(keepminute , keepsecond);
                            }
                            else
                            {
                                if (mt != null)
                                {
                                    mt.start();
                                }
                            }


                            if ((keepsecond == -1 && keepminute == -1) && myTurn == 0)
                            {
                                mt = new Mytimer(9 , 59);
                                mt.start();
                            }

                            myTurn = 1 - myTurn;

                            if (myTurn == 1)
                            {
                                myMove = "私のターン";
                                theLabel1.setText(myMove);
                            }
                            else
                            {
                                myMove = "相手のターン";
                                theLabel1.setText(myMove);
                            }

                            if (theColor == myColor)
                            {
                                //送信元クライアントでの処理
                                buttonArray[YthePnum][XthePnum].setIcon(myIcon);

                            }
                            else
                            {
                                //送信先クライアントでの処理
                                buttonArray[YthePnum][XthePnum].setIcon(yourIcon);
                            }

//                            枚数表示
                            int ss = sunCount();
                            String SS = String.valueOf(ss);
                            sunCountLabel.setText("太陽" + "：" + SS);

                            int rr = rainCount();
                            String RR = String.valueOf(rr);
                            rainCountLabel.setText("雨" + "：" + RR);

                            restore();

                            if (myTurn == 1) tips();
                            System.out.println("探索処理が終わりました。");

                            if (pass() && myTurn == 1)
                            {
                                // 次の人がパスならサーバに「PASS」のメッセージを送る
                                String msg = "PASS";
                                out.println(msg);
                                out.flush();
                            }
                        }
                        else if (cmd.equals("FRIP"))
                        {
                            String XthePName = inputTokens[1];
                            String YthePName = inputTokens[2];
                            int XthePnum = Integer.parseInt(XthePName);
                            int YthePnum = Integer.parseInt(YthePName);
                            int theColor = Integer.parseInt(inputTokens[3]);
                            // System.out.println("XthePName"+ XthePName + "YthePName"+ YthePName );
                            if (theColor == myColor)
                            {
                                buttonArray[YthePnum][XthePnum].setIcon(myIcon);
                            }
                            else
                            {
                                buttonArray[YthePnum][XthePnum].setIcon(yourIcon);
                            }

                        }
                        else if (cmd.equals("PASS"))
                        {
                            // ターンが次の次の人に返すように設定する
                            if (myTurn == 1)
                            {
                                mt.running = false; // 止める処理
                                mt = new Mytimer(keepminute , keepsecond);
                            }
                            else
                            {
                                if (mt != null)
                                {
                                    mt.start();
                                }
                            }

                            myTurn = 1 - myTurn;

                            if (myTurn == 1) tips();
                            System.out.println("探索処理が終わりました。");

                            if (myTurn == 1)
                            {
                                myMove = "私のターン";
                                theLabel1.setText(myMove);
                            }
                            else
                            {
                                myMove = "相手のターン";
                                theLabel1.setText(myMove);
                            }
                            // System.out.println("ya");
                            if (pass() && myTurn == 1)
                            {
                                // 次の人がパスならサーバに「PASS」のメッセージを送る
                                String msg = "JUDGE";
                                out.println(msg);
                                out.flush();
                            }
                        }
                        else if (cmd.equals("JUDGE"))
                        {
                            judge();
                        }
                        else if (cmd.equals("CHAT"))
                        {
//                            チャット内容を送る
                            taMain.append(inputTokens[1] + inputTokens[2] + inputTokens[3] + "\n");//メッセージの内容を出力用テキストに追加する
                        }
                        else if (cmd.equals("TIMEOUT"))
                        {
//                            時間切れで負けた時の処理
                            if (mt != null) mt.running = false;

                            if (myTurn == 1)
                            {
                                System.out.println("あなたの負けです");
                                GameWindow gw1 = new GameWindow("勝敗" , 915 , 426);
                                DrawCanvas dc1 = new DrawCanvas();
                                gw1.add(dc1);
                                gw1.setVisible(true);
                                gw1.setResizable(false);
                            }
                            else
                            {
                                System.out.println("あなたの勝ちです");
                                GameWindow gw2 = new GameWindow("勝敗" , 915 , 426);
                                DrawCanvas dc2 = new DrawCanvas();
                                gw2.add(dc2);
                                gw2.setVisible(true);
                                gw2.setResizable(false);
                            }
                        }
                        else if (cmd.equals("TIMESTART"))
                        {
                            //mt.running = false; // 止める処理
//                            時間のスタート
                            taMain.append("ゲームが始まりました。" + "\n");
                            if (myTurn == 1)
                            {
                                mt = new Mytimer(9 , 59);
                                mt.start();
                            }
                        }
                        else if (cmd.equals("SUNSET"))
                        {
//                            台風のアクションが起こった時に太陽アイコンのセットを行う
                            String Xnum = inputTokens[1];
                            String Ynum = inputTokens[2];
                            int x = Integer.parseInt(Xnum);
                            int y = Integer.parseInt(Ynum);
                            buttonArray[x][y].setIcon(sunIcon);

                            buttonArray[3][3].setIcon(sunIcon);
                            buttonArray[4][4].setIcon(sunIcon);
                            buttonArray[4][3].setIcon(rainIcon);
                            buttonArray[3][4].setIcon(rainIcon);

                        }
                        else if (cmd.equals("RAINSET"))
                        {
//                            台風のアクションが起こった時にアイコンのセットを行う
                            String Xnum = inputTokens[1];
                            String Ynum = inputTokens[2];
                            int x = Integer.parseInt(Xnum);
                            int y = Integer.parseInt(Ynum);
                            buttonArray[x][y].setIcon(rainIcon);

                            buttonArray[3][3].setIcon(sunIcon);
                            buttonArray[4][4].setIcon(sunIcon);
                            buttonArray[4][3].setIcon(rainIcon);
                            buttonArray[3][4].setIcon(rainIcon);
                        }
                        else if (cmd.equals("CHANGE"))
                        {
//                          台風が起こった時にターンを入れ替える
                            if (myTurn == 1)
                            {
                                mt.running = false; // 止める処理
                                mt = new Mytimer(keepminute , keepsecond);
                            }
                            else
                            {
                                if (mt != null)
                                {
                                    mt.start();
                                }
                            }

                            myTurn = 1 - myTurn;

                            if (myTurn == 1)
                            {
                                myMove = "私のターン";
                                theLabel1.setText(myMove);
                            }
                            else
                            {
                                myMove = "相手のターン";
                                theLabel1.setText(myMove);
                            }


                            restore();

                            int ss = sunCount();
                            String SS = String.valueOf(ss);
                            sunCountLabel.setText("太陽" + "：" + SS);

                            int rr = rainCount();
                            String RR = String.valueOf(rr);
                            rainCountLabel.setText("雨" + "：" + RR);

                            if (myTurn == 1) tips();
                            System.out.println("探索処理が終わりました。");

                            if (pass() && myTurn == 1)
                            {
                                // 次の人がパスならサーバに「PASS」のメッセージを送る
                                String msg = "PASS";
                                out.println(msg);
                                out.flush();
                            }
                        }
                        else if (cmd.equals("SET_STARTCOUNT_0"))
                        {
//                            startcountを０にして、スタートボタンを押せないようにする
                            startcount = 0;
                        }
                        else if (cmd.equals("ENEMYTIME"))
                        {
//                            相手の時間を送りつけて表示する
                            String minute = inputTokens[1];
                            String second = inputTokens[2];
                            int secondInt = Integer.parseInt(second);
                            int theColor = Integer.parseInt(inputTokens[3]);

                            if (myTurn == 0 && myColor != theColor)
                            {
                                if (secondInt <= 9)
                                {
                                    enemyLabeltime.setText("0" + minute + ":" + "0" + second);
                                }
                                else
                                {
                                    enemyLabeltime.setText("0" + minute + ":" + second);
                                }
                            }
                        }
                    }
                    else
                    {
                        break;
                    }


                }
                socket.close();

            }
            catch (IOException e)
            {
                System.err.println("エラーが発生しました: " + e);
            }
        }
    }

    public static void main(String[] args)
    {
        MyClient net = new MyClient();
        net.setVisible(true);
    }

    public void mouseClicked(MouseEvent e)
    {    //ボタンをクリックしたときの処理
        System.out.println("クリック");
        JButton theButton = (JButton) e.getComponent();//クリックしたオブジェクトを得る．型が違うのでキャストする
        String theArrayIndex = theButton.getActionCommand();//ボタンの配列の番号を取り出す
        Icon theIcon = theButton.getIcon();//theIconには，現在のボタンに設定されたアイコンが入る
        System.out.println(theIcon);//デバッグ（確認用）に，クリックしたアイコンの名前を出力する
        int temp = Integer.parseInt(theArrayIndex);
        int x = temp / 8;
        int y = temp % 8;

//        チャットのテキストボックスに書かれた内容が送られる
        if (temp == 80)
        {
            String chatmsg = tfKeyin.getText();
            String msg = "CHAT" + " " + myName + " " + ":" + " " + chatmsg;//入力したテキストを得る
            tfKeyin.setText("");//tfKeyinのTextをクリアする

            if (chatmsg.length() > 0)
            {//入力したメッセージの長さが０で無ければ，
                out.println(msg);
                out.flush();
            }

            return;
        }

//        台風ボタン
        if (temp == 67)
        {
            if ((keepminute != 0 && keepsecond != 0) && (keepminute != -1 && keepsecond != -1))
            {
                if (typhooncount == 1 && myTurn == 1)
                {
                    Random random = new Random();
                    typhooncount = 0;
                    int s = sunCount();
                    int r = rainCount();

//                1が雨、０が太陽
                    if (myColor == 0)
                    {
                        for (; r > 0; --r)
                        {
                            int randomX = random.nextInt(8);
                            int randomY = random.nextInt(8);
                            String msg = "RAINSET" + " " + randomX + " " + randomY;
                            out.println(msg);
                            out.flush();
                            repaint();
                        }

                        for (; s > 0; --s)
                        {
                            int randomX = random.nextInt(8);
                            int randomY = random.nextInt(8);
                            String msg = "SUNSET" + " " + randomX + " " + randomY;
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }

                    if (myColor == 1)
                    {
                        for (; s > 0; --s)
                        {
                            int randomX = random.nextInt(8);
                            int randomY = random.nextInt(8);
                            String msg = "SUNSET" + " " + randomX + " " + randomY;
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                        for (; r > 0; --r)
                        {
                            int randomX = random.nextInt(8);
                            int randomY = random.nextInt(8);
                            String msg = "RAINSET" + " " + randomX + " " + randomY;
                            out.println(msg);
                            out.flush();
                            repaint();
                        }
                    }
                    out.println("CHANGE");
                    out.flush();
                    repaint();
                }
                else
                {
                    taMain.append("もう台風は起こせません！" + "\n");
                }

            }
            return;
        }

//        時間をスタートさせる
        if (startcount == 1)
        {
            if (temp == 64 && myTurn == 0)
            {
                out.println("SET_STARTCOUNT_0");
                out.flush();
                repaint();

                String timemsg = "TIMESTART";
                out.println(timemsg);
                out.flush();
                repaint();
            }
            else if (temp != 64)
            {
                if (mt != null)
                {
                    mt.running = false;
                }
            }
            return;
        }

//        BGMの再生
        if (temp == 65)
        {
            theSoundPlayer1 = new SoundPlayer("ho00302.wav");
            theSoundPlayer1.SetLoop(true);//ＢＧＭとして再生を繰り返す
            theSoundPlayer1.play();
            taMain.append("BGMが再生されました。" + "\n");
            return;
        }

//      BGMの停止
        if (temp == 66)
        {
            theSoundPlayer1.stop();
            taMain.append("BGMが止まりました。" + "\n");
            return;
        }
//        if ((keepsecond == -1 && keepminute == -1) && myTurn == 1)
//        {
//            if (myTurn == 0)
//            {
//                mt = new Mytimer(9 , 59);
//                mt.start();
//            }
//        }

        if ((keepminute != 0 && keepsecond != 0) && (keepminute != -1 && keepsecond != -1))
        {
            if (myTurn == 1 && theIcon == tipIcon)
            {
                if (judgeButton(y , x))
                {
                    String msg = "PLACE" + " " + x + " " + y + " " + myColor;
                    System.out.println(msg);
                    out.println(msg);//送信データをバッファに書き出す
                    out.flush();//送信データをフラッシュ（ネットワーク上にはき出す）する
                    repaint();//画面のオブジェクトを描画し直す
                }
                else
                {
                    //置けない
                    System.out.println("そこには配置できません");

                }
            }
        }
        /*
        String timemsg = "TIMER";
        out.println(timemsg);
        out.flush();
        repaint();
        */

    }


    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    //    太陽アイコンの枚数を数える
    private int sunCount()
    {
        int scount = 0;
        for (int j = 0; j < 8; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                Icon sunnyIcon = buttonArray[i][j].getIcon();

                if (sunnyIcon == sunIcon)
                {
                    scount++;
                }
            }
        }
        return scount;
    }

    //    雨アイコンの枚数を数える
    private int rainCount()
    {
        int rcount = 0;
        for (int j = 0; j < 8; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                Icon rainyIcon = buttonArray[i][j].getIcon();

                if (rainyIcon == rainIcon)
                {
                    rcount++;
                }
            }
        }
        return rcount;
    }

    private boolean judgeButton(int y , int x)
    {
        boolean flag = false;

        for (int i = -1; i < 2; i++)
        {
            for (int j = -1; j < 2; j++)
            {
                int flipNum = flipButtons(y , x , j , i);
                // Icon ClickedIcon = buttonArray[y+i][x+j].getIcon();
                if (flipNum > 0)
                {
                    flag = true;
                    for (int dy = j, dx = i, k = 0; k < flipNum; k++ , dy += j , dx += i)
                    {
                        //ボタンの位置情報を作る
                        int msgy = y + dy;
                        int msgx = x + dx;


                        //サーバに情報を送る
                        String msg = "FRIP" + " " + msgx + " " + msgy + " " + myColor;
                        out.println(msg);
                        out.flush();
                    }
                }
            }
        }
        //色々な条件からflagをtrueにするか判断する
        return flag;
    }

    public int flipButtons(int y , int x , int j , int i)
    {
        int flipNum = 0;

        for (int dy = j, dx = i; ; dy += j , dx += i)
        {
//            if (y + dy > 7 || x + dx > 7) return 0;
            if ((dy == 0) && (dx == 0))
            {
                return 0;
            }
//            if (y + dy < 0 || x + dx < 0) return 0;
            if (canAccessArray(x + dx , y + dy))
            {
                Icon CIcon;

                CIcon = buttonArray[y + dy][x + dx].getIcon();

                if (CIcon == boardIcon)
                {
                    return 0;
                }
                else if (CIcon == myIcon)
                {
                    return flipNum;
                }
                else if (CIcon == tipIcon)
                {
                    return 0;
                }
                else
                {
                    flipNum++;
                }
            }
            else
            {
                return 0;
            }

//            if (CIcon == boardIcon)
//            {
//                return 0;
//            }
//            else if (CIcon == myIcon)
//            {
//                return flipNum;
//            }
//            else if (CIcon == tipIcon)
//            {
//                return 0;
//            }
//            else
//            {
//                flipNum++;
//            }
        }
    }


    //    ボタンの配列内か調べる
    private boolean canAccessArray(int x , int y)
    {
        if ((x >= 0 && x < 8) && (y >= 0 && y < 8))
        {
            return true;
        }

        return false;
    }

    //   パスできるか判定する
    private boolean pass()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Icon passIcon = buttonArray[j][i].getIcon();

                if (passIcon == boardIcon || passIcon == tipIcon)
                {

                    for (int m = -1; m < 2; m++)
                    {
                        for (int n = -1; n < 2; n++)
                        {
                            if (flipButtons(j , i , m , n) > 0)
                            {
                                return false;
                            }

                        }
                    }
                }

            }
        }

        return true;


    }

    // 勝敗を下す
    private void judge()
    {
        mt.running = false;
        System.out.println("fin");

        for (int j = 0; j < 8; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                Icon judgeIcon = buttonArray[i][j].getIcon();
                if (judgeIcon == sunIcon)
                {
                    sIcon++;
                }
                else if (judgeIcon == rainIcon)
                {
                    rIcon++;
                }
            }
        }
        if (sIcon > rIcon)
        {
            if (myColor == 0)
            {
                System.out.println("太陽の勝ち");
                GameWindow gw1 = new GameWindow("勝敗" , 915 , 426);
                DrawCanvas dc1 = new DrawCanvas();
                gw1.add(dc1);
                gw1.setVisible(true);
                gw1.setResizable(false);
            }
            else
            {
                GameWindow gw2 = new GameWindow("勝敗" , 915 , 424);
                DrawCanvas dc2 = new DrawCanvas();
                gw2.add(dc2);
                gw2.setVisible(true);
                gw2.setResizable(false);
            }
        }
        else if (rIcon > sIcon)
        {
            if (myColor == 1)
            {
                System.out.println("雨の勝ち");
                GameWindow gw1 = new GameWindow("勝敗" , 915 , 424);
                DrawCanvas dc1 = new DrawCanvas();
                gw1.add(dc1);
                gw1.setVisible(true);
                gw1.setResizable(false);
            }
            else
            {
                GameWindow gw2 = new GameWindow("" , 915 , 426);
                DrawCanvas dc2 = new DrawCanvas();
                gw2.add(dc2);
                gw2.setVisible(true);
                gw2.setResizable(false);
            }
        }
        else
        {
            GameWindow gw3 = new GameWindow("勝敗" , 915 , 424);
            DrawCanvas dc3 = new DrawCanvas();
            gw3.add(dc3);
            gw3.setVisible(true);
            gw3.setResizable(false);
        }
    }

    // ヒントの表示
    private void tips()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Icon yukiIcon = buttonArray[j][i].getIcon();

                if (yukiIcon == boardIcon)
                {

                    for (int m = -1; m < 2; m++)
                    {
                        for (int n = -1; n < 2; n++)
                        {
                            if (flipButtons(j , i , m , n) > 0)
                            {
                                buttonArray[j][i].setIcon(tipIcon);
                            }

                        }
                    }
                }

            }

        }
    }

    // チップアイコンをボードアイコンに戻す
    private void restore()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Icon restoreIcon = buttonArray[j][i].getIcon();

                if (restoreIcon == tipIcon)
                {
                    buttonArray[j][i].setIcon(boardIcon);
                }

            }

        }
    }

    //    勝敗結果のウィンドウ
    static class GameWindow extends JFrame
    {

        public GameWindow(String title , int width , int height)
        {
            super(title);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(width , height);
            setLocationRelativeTo(null);
        }
    }

    //   勝敗結果を表示
    class DrawCanvas extends JPanel
    {
        Image win = Toolkit.getDefaultToolkit().getImage("WIN.png");
        Image lose = Toolkit.getDefaultToolkit().getImage("LOSE.png");
        Image draw = Toolkit.getDefaultToolkit().getImage("DRAW.png");

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            //画像の表示　0が太陽
            if ((sIcon > rIcon && myColor == 0) || (rIcon > sIcon && myColor == 1))
            {
                g.drawImage(win , 0 , 0 , this);
            }

            if ((sIcon > rIcon && myColor == 1) || (rIcon > sIcon && myColor == 0))
            {
                g.drawImage(lose , 0 , 0 , this);
            }

            if ((keepsecond == 0 && keepminute == 0) || (keepminute == -1 && keepsecond == -1))
            {
                if (myTurn == 0)
                {
                    g.drawImage(win , 0 , 0 , this);
                }

                if (myTurn == 1)
                {
                    g.drawImage(lose , 0 , 0 , this);
                }
            }

            if(sIcon == rIcon)
            {
                g.drawImage(draw , 0 , 0 , this);
            }
        }
    }

    //   BGMの起動と停止
    public class SoundPlayer
    {
        boolean stopFlag = false;
        Thread soundThread = null;
        private AudioFormat format = null;
        private DataLine.Info info = null;
        private Clip clip = null;
        private boolean loopFlag = false;

        public SoundPlayer(String pathname)
        {
            File file = new File(pathname);
            try
            {
                format = AudioSystem.getAudioFileFormat(file).getFormat();
                info = new DataLine.Info(Clip.class , format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(AudioSystem.getAudioInputStream(file));
                //clip.setLoopPoints(0,clip.getFrameLength());//無限ループとなる
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        public void SetLoop(boolean flag)
        {
            loopFlag = flag;
        }

        public void play()
        {
            soundThread = new Thread()
            {
                public void run()
                {
                    long time = clip.getFrameLength();//44100で割ると再生時間（秒）がでる
                    System.out.println("PlaySound time=" + time);
                    long endTime = System.currentTimeMillis() + time * 1000 / 44100;
                    clip.start();
                    System.out.println("PlaySound time=" + (int) (time / 44100));
                    while (true)
                    {
                        if (stopFlag)
                        {//stopFlagがtrueになった終了
                            System.out.println("PlaySound stop by stopFlag");
                            clip.stop();
                            return;
                        }
                        System.out.println("endTime=" + endTime);
                        System.out.println("currentTimeMillis=" + System.currentTimeMillis());
                        if (endTime < System.currentTimeMillis())
                        {//曲の長さを過ぎたら終了
                            System.out.println("PlaySound stop by sound length");
                            if (loopFlag)
                            {
                                clip.loop(1);//無限ループとなる
                            }
                            else
                            {
                                clip.stop();
                                return;
                            }
                        }
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            };
            soundThread.start();
        }

        public void stop()
        {
            stopFlag = true;
            System.out.println("StopSound");
        }

    }
}



